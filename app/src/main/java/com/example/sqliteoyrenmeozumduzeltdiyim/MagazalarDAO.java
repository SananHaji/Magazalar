package com.example.sqliteoyrenmeozumduzeltdiyim;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class MagazalarDAO {

    public void addMagaza(DBHelper dbh, String magaza_ad, String magaza_sahibi, String magaza_elaqe_nomresi){

        SQLiteDatabase dbx = dbh.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("magaza_ad", magaza_ad);
        values.put("magaza_sahibi", magaza_sahibi);
        values.put("magaza_elaqe_nomresi", magaza_elaqe_nomresi);

        dbx.insertOrThrow("magazalar", null, values);
        dbx.close();

    }

    public ArrayList<Magazalar> getMagazalar(DBHelper dbh){
        ArrayList<Magazalar> butunMagazalar = new ArrayList<>();
        SQLiteDatabase dbx = dbh.getWritableDatabase();
        @SuppressLint("Recycle") Cursor cursor = dbx.rawQuery("SELECT * FROM magazalar", null);

        while (cursor.moveToNext()){
            Magazalar magaza = new Magazalar(
                    cursor.getInt(cursor.getColumnIndex("magaza_id")),
                    cursor.getString(cursor.getColumnIndex("magaza_ad")),
                    cursor.getString(cursor.getColumnIndex("magaza_sahibi")),
                    cursor.getString(cursor.getColumnIndex("magaza_elaqe_nomresi"))
                    );
            butunMagazalar.add(magaza);
        }


        return butunMagazalar;
    }

}
