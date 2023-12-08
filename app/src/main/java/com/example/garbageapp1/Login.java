package com.example.garbageapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    Users users;
    DbHelper dbHelper = new DbHelper(Login.this);

    public EditText email;
    public EditText password;
    public Button btn_login;

    Switch login_type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.et_gmail);
        password = findViewById(R.id.et_pass);
        btn_login = findViewById(R.id.btn_Login);
        login_type = findViewById(R.id.login_type);


        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Email = email.getText().toString();
                String Password = password.getText().toString();


                String userType;

                if(login_type.isChecked()){
                    userType = "Company";
                }
                else{
                    userType = "Resident";
                }


                boolean result = dbHelper.login(Email,Password,userType);

                if(result){


                    users.email = Email;
                    users.type = userType;

                    Toast.makeText(Login.this, "User exists", Toast.LENGTH_SHORT).show();
                    if(userType == "Resident"){
                        Intent i = new Intent(Login.this,Orders.class);

                        startActivity(i);
                    }
                    else{
                        Intent i = new Intent(Login.this,CompanyDash1.class);
                        startActivity(i);
                    }
                }
                else{
                    Toast.makeText(Login.this, "User does not exist", Toast.LENGTH_SHORT).show();
                }


            }
        });

    }



}


