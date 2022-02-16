package com.example.gestionefile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button leggi, scrivi;
    EditText nomefile;
    Gestore gs;
    @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        leggi = (Button)findViewById(R.id.leggi);
        scrivi = (Button)findViewById(R.id.scrivi);
        nomefile = (EditText)findViewById(R.id.nomefile);
        gs = new Gestore();
        leggi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                System.out.println(nomefile.getText().toString());
                StringBuilder stringaLetta = gs.leggiFile("filedaleggere.txt",getApplicationContext());
                Toast.makeText(getApplicationContext(), stringaLetta, Toast.LENGTH_LONG).show();
            }
        });

        scrivi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String stringa = gs.scriviFile("filedascrivere",getApplicationContext());
                Toast.makeText(getApplicationContext(), stringa, Toast.LENGTH_LONG).show();
            }
        });

    }
}