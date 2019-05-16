package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBase extends SQLiteOpenHelper {
    private final Context fContext;
    public DataBase(Context context)
    {
        super(context, "db", null, 1);
        fContext = context;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table train (id INTEGER, name TEXT, description TEXT, time INTEGER, img TEXT, type TEXT);");
        ContentValues values = new ContentValues();
        Resources res = fContext.getResources();
        String[] names = res.getStringArray(R.array.name);
        String[] imgs = res.getStringArray(R.array.img);
        int length = names.length;
        for (int i = 0; i < length; i++) {

            values.put("id", i);
            values.put("name", names[i]);
            values.put("description", "");
            values.put("time", 1);
            values.put("img", imgs[i]);
            values.put("type", "cardio");
            db.insert("train", null, values);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
