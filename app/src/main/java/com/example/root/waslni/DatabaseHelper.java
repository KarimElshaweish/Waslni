package com.example.root.waslni;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.xml.validation.Validator;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_Name="UserManger";
    private static final String Table_Users="users";
    private static final String Key_ID="id";
    private static final String Key_Name="name";
    private static final String Key_Email="email";
    private static final String Key_passowrd="password";

    public  DatabaseHelper(Context context){
        super(context,DATABASE_Name,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String Creat_User_Table="CREATE TABLE "+ Table_Users+" ( "+
                Key_ID+" INTEGER PRIMARY KEY , "+Key_Name+" TEXT, "+
                Key_Email+" TEXT, "+Key_passowrd+" TEXT)";
        db.execSQL(Creat_User_Table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " +Table_Users);
        onCreate(db);
    }
    void addUser(Users user){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(Key_Name,user.getName());
        values.put(Key_Email,user.getEmail());
        values.put(Key_passowrd,user.getPassword());
        db.insert(Table_Users,null,values);
        db.close();
    }
    Users getUser(int id){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.query(Table_Users,new String[]{Key_ID,Key_Name,Key_passowrd,Key_Email},
                Key_ID+"=?",
                new String[]{String.valueOf(id)},null,
                null,null,null);
        if(cursor!=null){
            cursor.moveToFirst();
        }
        Users user=new Users(Integer.parseInt(cursor.getString(0)),cursor.getString(1),
                cursor.getString(2),
                cursor.getString(3));
        return user;
    }
    public List<Users>getAllList(){
        List<Users>usersList=new ArrayList<>();
        String selcQuery="SELECT * FROM "+Table_Users;
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery(selcQuery,null);
        if(cursor.moveToFirst()){
            do {
                Users users=new Users();
                users.setId(Integer.parseInt(cursor.getString(0)));
                users.setName(cursor.getString(1));
                users.setPassword(cursor.getString(2));
                users.setEmail(cursor.getString(3));
                usersList.add(users);
            }while (cursor.moveToNext());
        }
        return  usersList;
    }
    public int updateUser(Users user){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(Key_Email,user.getEmail());
        values.put(Key_Name,user.getName());
        values.put(Key_passowrd,user.getPassword());
        return  db.update(Table_Users,values,Key_ID+"=?",
                new String[]{String.valueOf(user.getId())});

    }
    public void deleteUser(Users users){
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete(Table_Users,Key_ID+"=?",
                new String[]{String.valueOf(users.getId())});
        db.close();
    }
    public  int get_user_count(){
        String CountSql="SELECT * FROM"+Table_Users;
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery(CountSql,null);
        return cursor.getCount();
    }
}
