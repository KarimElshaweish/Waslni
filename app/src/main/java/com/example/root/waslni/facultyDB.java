package com.example.root.waslni;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 1/7/18.
 */

public class facultyDB extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_Name="FacultyManger";
    private static final String Table_Users="faculty";
    private static final String Key_ID="id";
    private static final String Key_key="name";
    private static final String Key_val="email";

    public  facultyDB(Context context){
        super(context,DATABASE_Name,null,DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String Creat_User_Table="CREATE TABLE "+ Table_Users+" ( "+
                Key_ID+" INTEGER PRIMARY KEY , "+Key_key+" TEXT, "+
                Key_val+" TEXT)";
        db.execSQL(Creat_User_Table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " +Table_Users);
        onCreate(db);
    }
    void addfaculty(faculty faculty){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(Key_key,faculty.getKey());
        values.put(Key_val,faculty.getVal());
        db.insert(Table_Users,null,values);
        db.close();
    }
    public List<faculty> getAllList(){
        List<faculty>facultyList=new ArrayList<>();
        String selcQuery="SELECT * FROM "+Table_Users;
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery(selcQuery,null);
        if(cursor.moveToFirst()){
            do {
                faculty faculty=new faculty();
                faculty.setId(Integer.parseInt(cursor.getString(0)));
                faculty.setKey(cursor.getString(1));
                faculty.setVal(cursor.getString(2));
                facultyList.add(faculty);
            }while (cursor.moveToNext());
        }
        return  facultyList;
    }
}
