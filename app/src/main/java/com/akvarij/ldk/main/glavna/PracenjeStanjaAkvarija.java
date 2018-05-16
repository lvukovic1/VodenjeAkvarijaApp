package com.akvarij.ldk.main.glavna;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.akvarij.ldk.main.akvarij.Nitrati;
import com.akvarij.ldk.main.akvarij.PHVrijednosti;
import com.akvarij.ldk.main.akvarij.TemperaturnaVrijednost;

public class PracenjeStanjaAkvarija extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pracenje_stanja_akvarija);


        Button nitrati = (Button)findViewById(R.id.nitratiBtn);
        nitrati.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startInetent = new Intent(getApplicationContext(), Nitrati.class);
                startActivities(new Intent[]{startInetent});
            }
        });

        Button PH = (Button)findViewById(R.id.phBtn);
        PH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startInetent = new Intent(getApplicationContext(), PHVrijednosti.class);
                startActivities(new Intent[]{startInetent});
            }
        });

        Button Temp = (Button)findViewById(R.id.temperaturaBtn);
        Temp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startInetent = new Intent(getApplicationContext(), TemperaturnaVrijednost.class);
                startActivities(new Intent[]{startInetent});
            }
        });


    }
}
