package com.akvarij.ldk.main.izracuni;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.akvarij.ldk.main.glavna.R;

public class Litraza extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_litraza);

//metoda za izracun litraze sa obzirom na duzinu, sirinu i visinu akvarija
        Button litrazaBtn = (Button) findViewById(R.id.litrazaBtn);
        litrazaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText duzina = (EditText) findViewById(R.id.duzina);
                EditText visina = (EditText) findViewById(R.id.visina);
                EditText sirina = (EditText) findViewById(R.id.sirina);
                TextView litrazaTextView = (TextView) findViewById(R.id.litrataTextView);

                int duzina1 = Integer.parseInt(duzina.getText().toString());
                int visina1 = Integer.parseInt(visina.getText().toString());
                int sirina1 = Integer.parseInt(sirina.getText().toString());
                int rezultat = (duzina1 * visina1 * sirina1) / 1000;
                litrazaTextView.setText(rezultat + "");
            }
        });
    }
}
