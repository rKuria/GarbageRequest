package com.example.garbageapp1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Entity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    DbHelper dbHelper = new DbHelper(Login.this);

    public EditText email;
    public EditText password;
    public Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.et_uname);
        password = findViewById(R.id.et_pass);
        btn_login = findViewById(R.id.btn_Login);


        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Email = email.getText().toString();
                String Password = password.getText().toString();

                boolean result = dbHelper.login(Email,Password);

                if(result){
                    Toast.makeText(Login.this, "User exists", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(Login.this, "User does not exist", Toast.LENGTH_SHORT).show();
                }



            }
        });

    }



}


