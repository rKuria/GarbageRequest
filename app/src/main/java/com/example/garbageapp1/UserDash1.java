package com.example.garbageapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.List;

public class UserDash1 extends AppCompatActivity {

    private ListView listView;
    private DbHelper dbHelper;
    Users users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_dash1);

        dbHelper = new DbHelper(getApplicationContext());

        listView = findViewById(R.id.user_List);
        List<String> list = dbHelper.getPreviousOrders(users.email);
        ListAdapter listAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, list);
        listView.setAdapter(listAdapter);
    }
}