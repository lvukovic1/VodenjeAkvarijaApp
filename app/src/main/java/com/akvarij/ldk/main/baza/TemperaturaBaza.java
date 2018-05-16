package com.akvarij.ldk.main.baza;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class TemperaturaBaza extends SQLiteOpenHelper {
    private Context con;
    public TemperaturaBaza(Context context) {
        super(context, "MyDatabaseTemp", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable="create table MyTable(xValues INTEGER, yValues INTEGER);";
        db.execSQL(createTable);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insertData(long valX,int valY){

        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("xValues",valX);
        contentValues.put("yValues",valY);

        db.insert("MyTable", null,contentValues);

    }
}
