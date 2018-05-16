package com.akvarij.ldk.main.glavna;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.akvarij.ldk.main.izracuni.Litraza;
import com.akvarij.ldk.main.izracuni.Svjetlina;

public class Izracunavanje extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_izracunavanje);

        //gumb litraža

        Button litraza = (Button)findViewById(R.id.IzracunBtn1);
        litraza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startInetent = new Intent(getApplicationContext(), Litraza.class);
                startActivities(new Intent[]{startInetent});
            }
        });

// gumb svjetlina
        Button svjetlina = (Button)findViewById(R.id.IzracunBtn2);
        svjetlina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startInetent = new Intent(getApplicationContext(), Svjetlina.class);
                startActivities(new Intent[]{startInetent});
            }
        });




    }
}
