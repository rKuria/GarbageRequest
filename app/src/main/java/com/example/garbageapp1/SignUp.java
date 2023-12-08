package com.example.garbageapp1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;


public class SignUp extends AppCompatActivity {

    //references to the controls

    Button btn_SignUp;

    RadioGroup rgTypes;

//    RadioButton r_btn1, r_btn2;

    Switch type;

    EditText et_name, et_email, et_password;

    TextView tv_name, tv_email, tv_password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        //this is where all the controls are being assigned
        //r is the resource folder

        btn_SignUp = findViewById(R.id.btn_SignUp);
        et_name = findViewById(R.id.et_name);
        et_email = findViewById(R.id.et_email);
        et_password = findViewById(R.id.et_password);
        tv_name = findViewById(R.id.tv_name);
        tv_email = findViewById(R.id.tv_email);
        tv_password = findViewById(R.id.tv_password);
        type = findViewById(R.id.type);
//        rgTypes = findViewById(R.id.rgTypes);
//        r_btn1 = findViewById(R.id.r_btn1);
//        r_btn2 = findViewById(R.id.r_btn2);



        //button listeners
        btn_SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userType;

//                else{
//                    findRadioButton(checkedID);
//                }

                if(type.isChecked()){
                    userType = "Company";
                }
                else{
                    userType = "Resident";
                }

                UserModel userModel;

                System.out.println(userType);
                System.out.println("-------------------------------------------------------------");

                Toast.makeText(SignUp.this, "Clicked", Toast.LENGTH_SHORT).show();

                try {
                    userModel = new UserModel(-1, et_name.getText().toString(), et_email.getText().toString(), et_password.getText().toString(),userType);
                    Toast.makeText(SignUp.this, "Trying", Toast.LENGTH_SHORT).show();
                }
                catch (Exception e){
                    Toast.makeText(SignUp.this, "Fail", Toast.LENGTH_SHORT).show();
                    userModel = new UserModel(-1, "none", "none", "none",userType);
                }

                DbHelper dbHelper = new DbHelper(SignUp.this);

                boolean success = dbHelper.addOne(userModel);
                if(success){

                    Toast.makeText(SignUp.this, "User created", Toast.LENGTH_SHORT).show();
                }
                else{

                    Toast.makeText(SignUp.this, "Fail to create user", Toast.LENGTH_SHORT).show();
                }
//                Toast.makeText(SignUp.this, "Success",Toast.LENGTH_SHORT);

            }
        });
    }

//    private void findRadioButton(int checkedID) {
//
//        switch (checkedID){
//            case R.id.r_btn1:
//                Toast.makeText(SignUp.this, "Button 1 was clicked", Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.r_btn2:
//                Toast.makeText(SignUp.this, "Button 2 was clicked", Toast.LENGTH_SHORT).show();
//        }
//
//    }


}


