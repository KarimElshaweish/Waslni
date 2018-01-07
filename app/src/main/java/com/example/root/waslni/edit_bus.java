package com.example.root.waslni;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class edit_bus extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_bus);
        Spinner spinner=findViewById(R.id.spinner1);
        Button btn_add_faculty=findViewById(R.id.btn_add_faculty);
        final EditText editText_add_facultt=findViewById(R.id.edittext_addfaculty);
        final facultyDB db=new facultyDB(this);
        List<faculty>list=db.getAllList();
        String[]items=new String[list.size()];
        for(int i=0;i<list.size();i++){
            String name=list.get(i).getKey();
            items[i]=name;
        }
        final ArrayList<String>arrayList=new ArrayList<>(Arrays.asList(items));
        final ArrayAdapter<String>adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,arrayList);
        spinner.setAdapter(adapter);
        btn_add_faculty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editText_add_facultt.getText()!=null) {
                    final String Faculty = editText_add_facultt.getText().toString();
                    editText_add_facultt.setText("");
                    editText_add_facultt.setHint("إسم الكلية");
                    db.addfaculty(new faculty(Faculty, Faculty));
                    arrayList.add(Faculty);
                    adapter.notifyDataSetChanged();
                    Toast.makeText(edit_bus.this, "تم", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(edit_bus.this, "اضف اسم كلية", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
