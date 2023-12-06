package com.example.garbageapp1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    public static final String USER_TABLE = "USER_TABLE";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_USER_NAME = "USER_NAME";
    public static final String COLUMN_USER_EMAIL = "USER_EMAIL";
    public static final String COLUMN_USER_PASSWORD = "USER_PASSWORD";

    public DbHelper(@Nullable Context context) {
        super(context, "user.db", null, 1 );
    }

    //called each time the db is accessed
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement = "CREATE TABLE " + USER_TABLE + "("  + COLUMN_USER_NAME + " TEXT , " + COLUMN_USER_EMAIL + " TEXT PRIMARY KEY, " + COLUMN_USER_PASSWORD + " TEXT)";

        db.execSQL(createTableStatement);

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

        long insert = db.insert(USER_TABLE,null, cv);
        if (insert == -1){
            return false;
        }
        else {
            return true;
        }

    }

    public boolean login(String email, String password){

        Cursor cursor;
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("email", email);
        cv.put("password",password);

        System.out.println(email);
        System.out.println(password);

//        cursor = db.rawQuery("SELECT * FROM " + USER_TABLE + " WHERE USER_EMAIL = ? AND USER_PASSWORD = ?", new String[] {email,password});
//        cursor = db.rawQuery("SELECT * FROM USER_TABLE WHERE USER_EMAIL = ? AND USER_PASSWORD = ?", new String[] {email,password});
        cursor = db.rawQuery("SELECT * FROM USER_TABLE WHERE USER_EMAIL = ? AND USER_PASSWORD = ?",new String[] {email,password});
//        cursor = db.rawQuery("SELECT * FROM USER_TABLE",null);
//        cursor = db.execSQL("SELECT * FROM USER_TABLE WHERE USER_EMAIL = " + email + " AND USER_PASSWORD = ?");

        System.out.println("///////////////////////////////////////////////////////////");
        System.out.println(cursor.getCount());
        if(cursor.getCount()>0){
            return true;
        }
        else{
            return  false;
        }
    }
}
