package com.example.garbageapp1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DbHelper extends SQLiteOpenHelper {

    Users user = new Users();

    public static final String USER_TABLE = "USER_TABLE";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_USER_NAME = "USER_NAME";
    public static final String COLUMN_USER_EMAIL = "USER_EMAIL";
    public static final String COLUMN_USER_PASSWORD = "USER_PASSWORD";


    public static final String ORDER_TABLE = "ORDER_TABLE";

    public static final String COLUMN_USERNAME = "NAME";
    public static final String COLUMN_LOCATION = "LOCATION";
    public static final String COLUMN_NUMBER = "MOBILE_NUMBER";

    public DbHelper(@Nullable Context context) {
        super(context, "user.db", null, 1 );
    }

    //called each time the db is accessed
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement = "CREATE TABLE " + USER_TABLE + "("  + COLUMN_USER_NAME + " TEXT , " + COLUMN_USER_EMAIL + " TEXT PRIMARY KEY, " + COLUMN_USER_PASSWORD + " TEXT, USER_TYPE TEXT)" ;
        String createTableStatement2 = "CREATE TABLE " + ORDER_TABLE + "(" + COLUMN_USERNAME + " TEXT, " + COLUMN_LOCATION +
                " TEXT, " + COLUMN_NUMBER + " TEXT, " + COLUMN_USER_EMAIL + " TEXT, " + "FOREIGN KEY (" + COLUMN_USER_EMAIL + ") " + "REFERENCES " + USER_TABLE + "(" + COLUMN_USER_EMAIL + "))";

        db.execSQL(createTableStatement);
        db.execSQL(createTableStatement2);

    }

    //called each time the db version is updated
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }

    public Boolean addOne(UserModel userModel){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_USER_NAME, userModel.getUsername());
        cv.put(COLUMN_USER_EMAIL, userModel.getEmail());
        cv.put(COLUMN_USER_PASSWORD, userModel.getPassword());
        cv.put("USER_TYPE", userModel.getType());

        System.out.println(userModel.getUsername());
        System.out.println(userModel.getEmail());
        System.out.println(userModel.getPassword());
        System.out.println(userModel.getType());
//        return  false;



        long insert = db.insert(USER_TABLE,null, cv);
        if (insert == -1){
            return false;
        }
        else {
            return true;
        }

    }

    public boolean login(String email, String password, String type){

        Cursor cursor;
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("email", email);
        cv.put("password",password);

        System.out.println(email);
        System.out.println(password);

//        cursor = db.rawQuery("SELECT * FROM " + USER_TABLE + " WHERE USER_EMAIL = ? AND USER_PASSWORD = ?", new String[] {email,password});
//        cursor = db.rawQuery("SELECT * FROM USER_TABLE WHERE USER_EMAIL = ? AND USER_PASSWORD = ?", new String[] {email,password});
          cursor = db.rawQuery("SELECT * FROM USER_TABLE WHERE USER_EMAIL = ? AND USER_PASSWORD = ? AND USER_TYPE = ?",new String[] {email,password,type});
//        cursor = db.rawQuery("SELECT * FROM USER_TABLE",null);
//        cursor = db.execSQL("SELECT * FROM USER_TABLE WHERE USER_EMAIL = " + email + " AND USER_PASSWORD = ?");

        System.out.println("///////////////////////////////////////////////////////////");
        System.out.println(cursor.getCount());
        if(cursor.getCount()>0){
//            System.out.println(cursor.getString());
//            user.setUsername(cursor.getString(0));
//            user.setEmail(cursor.getString(1));
//            user.setType(cursor.getString(3));
            return true;
        }
        else{
            return  false;
        }
    }


    public Boolean addOrder(OrdersModel orders){
        System.out.println(orders.getMobile());
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_USERNAME, orders.getUsername());
        cv.put(COLUMN_LOCATION, orders.getLocation());
        cv.put(COLUMN_NUMBER, orders.getMobile());
        cv.put(COLUMN_USER_EMAIL, orders.getEmail());

        long insert = db.insert (ORDER_TABLE, null, cv);
        if (insert==-1){
            return false;
        }
        else {
            return true;
        }
    }

    public List<String> getPreviousOrders(String email){
        SQLiteDatabase db = this.getReadableDatabase();
        List<String> arrayList = new ArrayList<>();

        String query = "SELECT * FROM " + ORDER_TABLE + " WHERE " + COLUMN_USER_EMAIL + " =?";
        Cursor cursor = db.rawQuery(query, new String[] {email});

        if(cursor.moveToFirst()){
            do{
                String name = cursor.getString(0);
                String location = cursor.getString(1);
                String number = cursor.getString(2);
                String data = "Order name: " + name + "\n Location: " + location + " \n Phone number: " + number;
                arrayList.add(data);
            }while(cursor.moveToNext());
        }
        else{
            return  null;
        }
        cursor.close();
        db.close();
        return arrayList;
    }

    public List<String> getAllOrders(){
        SQLiteDatabase db = this.getReadableDatabase();
        List<String> arrayList = new ArrayList<>();

        String query = "SELECT * FROM " + ORDER_TABLE;
        Cursor cursor = db.rawQuery(query, new String[] {});

        if(cursor.moveToFirst()){
            do{
                String name = cursor.getString(0);
                String location = cursor.getString(1);
                String number = cursor.getString(2);
                String data = "Order name: " + name + "\n Location: " + location + " \n Phone number: " + number;
                arrayList.add(data);
            }while(cursor.moveToNext());
        }
        else{
            return  null;
        }
        cursor.close();
        db.close();
        return arrayList;
    }



}
