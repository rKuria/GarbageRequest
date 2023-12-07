package com.example.garbageapp1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper2 extends SQLiteOpenHelper {

    public static final String ORDER_TABLE = "ORDER_TABLE";

    public static final String COLUMN_USERNAME = "NAME";
    public static final String COLUMN_LOCATION = "LOCATION";
    public static final String COLUMN_NUMBER = "MOBILE_NUMBER";

    public DbHelper2(@Nullable Context context) {super(context, "order.db", null, 1);}


    //called each time the db is accessed
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement = "CREATE TABLE " + ORDER_TABLE + "(" + COLUMN_USERNAME + "TEXT, " + COLUMN_LOCATION +
        "TEXT," + COLUMN_NUMBER + "TEXT)";

        db.execSQL(createTableStatement);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


}
