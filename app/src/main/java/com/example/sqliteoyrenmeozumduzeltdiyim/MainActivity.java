package com.example.sqliteoyrenmeozumduzeltdiyim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editTextMagazaAdi;
    private EditText editTextMagazaSahibi;
    private EditText editTextMagazaElaqeNomresi;
    private Button buttonElaveEt;
    private Button buttonMagazalariGor;

    private DBHelper dbh = new DBHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextMagazaAdi = findViewById(R.id.magazaAd);
        editTextMagazaSahibi = findViewById(R.id.magaza_sahibi);
        editTextMagazaElaqeNomresi = findViewById(R.id.magaza_elaqe_nomresi);
        buttonElaveEt = findViewById(R.id.elave_et);
        buttonMagazalariGor = findViewById(R.id.magazalari_gor);

        final String errorText = "cannot be empty";
        editTextMagazaAdi.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus){
                    if(TextUtils.isEmpty(editTextMagazaAdi.getText().toString())){
                        editTextMagazaAdi.setError(errorText);
                    }
                }
            }
        });

        editTextMagazaSahibi.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus){
                    if(TextUtils.isEmpty(editTextMagazaSahibi.getText().toString())){
                        editTextMagazaSahibi.setError(errorText);
                    }
                }
            }
        });

        editTextMagazaElaqeNomresi.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus){
                    if(TextUtils.isEmpty(editTextMagazaElaqeNomresi.getText().toString())){
                        editTextMagazaElaqeNomresi.setError(errorText);
                    }
                }
            }
        });

        buttonElaveEt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(
                        !TextUtils.isEmpty(editTextMagazaAdi.getText().toString())
                        &&!TextUtils.isEmpty(editTextMagazaSahibi.getText().toString())
                        &&!TextUtils.isEmpty(editTextMagazaElaqeNomresi.getText().toString())
                ){
                    // magaza elave olunur
                    new MagazalarDAO().addMagaza(
                            dbh,
                            editTextMagazaAdi.getText().toString(),
                            editTextMagazaSahibi.getText().toString(),
                            editTextMagazaElaqeNomresi.getText().toString());

                    editTextMagazaAdi.setText("");
                    editTextMagazaElaqeNomresi.setText("");
                    editTextMagazaSahibi.setText("");
                    editTextMagazaElaqeNomresi.clearFocus();
                    Toast.makeText(getApplicationContext(), "Mağaza əlavə olundu.",Toast.LENGTH_SHORT).show();
                    goMagazalarActivity();

                }else{
                    Toast.makeText(getApplicationContext(),"Fields cannot be EMPTY!!!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        buttonMagazalariGor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goMagazalarActivity();
            }
        });



    }
    public void goMagazalarActivity(){
        Intent intent = new Intent(MainActivity.this, MagazalarActivity.class);
        startActivity(intent);

    }
}
