package com.example.garbageapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.List;

public class DisplayOrders extends AppCompatActivity {
    private DbHelper dbHelper;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_orders);

        dbHelper = new DbHelper(getApplicationContext());

        listView = findViewById(R.id.view_All);
        List<String> list = dbHelper.getAllOrders();
        ListAdapter listAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, list);
        listView.setAdapter(listAdapter);
    }
}