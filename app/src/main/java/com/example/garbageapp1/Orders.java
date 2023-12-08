package com.example.garbageapp1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Orders  extends AppCompatActivity {

    Users users;

    private EditText order_name;
    private EditText order_location;
    private EditText phone_number;

    private Button order_submit, view_order;
    private DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders);

        order_name = findViewById(R.id.name_enter);
        order_location = findViewById(R.id.loc_enter);
        phone_number = findViewById(R.id.num_enter);
        order_submit = findViewById(R.id.btn_order);
        view_order = findViewById(R.id.view_order);
        dbHelper = new DbHelper(getApplicationContext());


//
        order_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = order_name.getText().toString().trim();
                String location = order_location.getText().toString().trim();
                String number = phone_number.getText().toString().trim();

                OrdersModel ordersModel = new OrdersModel(name, location, number, users.email);

                boolean success = dbHelper.addOrder(ordersModel);

                if(success){
                    Toast.makeText(Orders.this, "Worked", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(Orders.this, "Nope", Toast.LENGTH_SHORT).show();
                }
            }
        });
        view_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), UserDash1.class);
                startActivity(intent);
            }
        });

    }

}
