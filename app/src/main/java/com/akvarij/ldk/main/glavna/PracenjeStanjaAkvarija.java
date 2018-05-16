package com.akvarij.ldk.main.glavna;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.akvarij.ldk.main.akvarij.Nitrati;

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


    }
}
