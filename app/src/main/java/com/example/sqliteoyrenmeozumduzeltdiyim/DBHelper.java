package com.example.sqliteoyrenmeozumduzeltdiyim;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    private static String dbName = "magazalar";
    private static int version = 1;


    public DBHelper(Context context) {
        super(context, dbName, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE magazalar (" +
                "magaza_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                " magaza_ad TEXT," +
                " magaza_sahibi TEXT," +
                "magaza_elaqe_nomresi TEXT);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS magazalar");
        onCreate(db);
    }
}
