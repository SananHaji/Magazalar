package com.example.sqliteoyrenmeozumduzeltdiyim;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MagazalarActivity extends AppCompatActivity {
    private ArrayList<Magazalar> magazalarArrayList;
    private ListView listView;
    private ArrayList<String> magazalarStrings = new ArrayList<>();
    private DBHelper dbHelper = new DBHelper(this);
    private ArrayAdapter<String> arrayAdapterMagazalar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_magazalar);

        listView = findViewById(R.id.listview);

        magazalarArrayList = new MagazalarDAO().getMagazalar(dbHelper);

        for (Magazalar magazalar:magazalarArrayList){

            String stringBuilder = magazalar.getMagaza_id() +
                    " | " + magazalar.getMagaza_ad() +
                    " | " + magazalar.getMagaza_sahibi() +
                    " | " + magazalar.getMagaza_elaqe_nomresi();
            magazalarStrings.add(stringBuilder);
        }

        arrayAdapterMagazalar = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                magazalarStrings
        );

//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//            }
//        });
        listView.setAdapter(arrayAdapterMagazalar);


    }
}
