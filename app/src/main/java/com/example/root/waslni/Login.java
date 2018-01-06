package com.example.root.waslni;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;
import java.util.jar.Attributes;

public class Login extends AppCompatActivity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button btn_login=findViewById(R.id.button_login);
        final EditText editText_name=findViewById(R.id.edit_text_email);
        final EditText editText_password=findViewById(R.id.edit_text_password);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseHelper db=new DatabaseHelper(Login.this);
                final String Passowrd=editText_password.getText().toString();
                final  String Email=editText_name.getText().toString();


                List<Users>list=db.getAllList();
                boolean find=false;
                for(Users u :list){
                    if(u.name.equals(Email)&&u.password.equals(Passowrd)){
                        find=!find;
                        break;
                    }
                }
                if(find){
                    Intent intent=new Intent(Login.this,MainActivity.class);
                    startActivity(intent);
                }
                else
                    Toast.makeText(Login.this, "تأكد من البريد الألكترونى او كلمة السر", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public  void navigate(View target){
        Intent intent=new Intent(Login.this,Signup.class);
        startActivity(intent);
    }
}
