package com.example.root.waslni;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Signup extends AppCompatActivity {

    Button btnSignUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        btnSignUp=findViewById(R.id.button_Signup);
     final   EditText editText_Email=(EditText)findViewById(R.id.edit_text_email);
     final   EditText editText_password=(EditText)findViewById(R.id.edit_text_password);
     final   EditText editText_Name=(EditText)findViewById(R.id.edit_text_name);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String Name=editText_Name.getText().toString();
                final String Password=editText_password.getText().toString();
                final String Email=editText_Email.getText().toString();
                varibles.Name=Name;
                if (Name.length()!=0&&Password.length()!=0&&Email.length()!=0) {
                    DatabaseHelper db = new DatabaseHelper(Signup.this);
                    //insert user
                    db.addUser(new Users(Name, Password, Email));
                    Intent intent = new Intent(Signup.this, MainActivity.class);
                    intent.putExtra("Name",Name);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(Signup.this, "إملئ كل الفرغات", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public  void navigate(View target){
        Intent intent=new Intent(Signup.this, Login.class);
        startActivity(intent);
    }
}
