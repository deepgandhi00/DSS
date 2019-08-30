package com.example.deepgandhi.dsslab2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {
    ListView listView;
    List<User> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        list = new ArrayList<>();

        listView = findViewById(R.id.listView);

        list.add(new User("user1","1234566"));
        list.add(new User("user2","324456"));
        list.add(new User("user3","74546346"));
        list.add(new User("user4","51364656"));
        list.add(new User("user5","3523535"));

        ListAdapterCustom listAdapterCustom = new ListAdapterCustom(Main2Activity.this,list);

        listView.setAdapter(listAdapterCustom);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(Main2Activity.this, list.get(i).getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
