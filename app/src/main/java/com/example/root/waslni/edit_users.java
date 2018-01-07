package com.example.root.waslni;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class edit_users extends AppCompatActivity {
    ArrayList<DataModel> dataModels;
    ListView listView;
    private static CustomAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_users);
        listView=(ListView)findViewById(R.id.list);

        dataModels= new ArrayList<>();
        adapter= new CustomAdapter(dataModels,getApplicationContext());
        DatabaseHelper db=new DatabaseHelper(this);
        List<Users>usersList=db.getAllList();
        for( Users u: usersList){
            dataModels.add(new DataModel(u.name,u.email,"نشط"));
        }
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                DataModel dataModel= dataModels.get(position);
                if(adapter.getItem(position).email.equals("نشط")) {
                    adapter.getItem(position).email = "متوقف";
                }
                else
                    adapter.getItem(position).email="نشط";
                adapter.notifyDataSetChanged();
                Snackbar.make(view, dataModel.getName()+"\n"+" Email: "+dataModel.getEmail(), Snackbar.LENGTH_LONG)
                        .setAction("No action", null).show();
            }
        });
    }
}
