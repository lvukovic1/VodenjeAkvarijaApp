package com.akvarij.ldk.main.glavna;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.akvarij.ldk.main.financije.Prodano;
import com.akvarij.ldk.main.flora_fauna.Biljke;
import com.akvarij.ldk.main.flora_fauna.Ribe;

public class PregledFloreFaune extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        Button ribe = (Button)findViewById(R.id.ribeBtn);
        ribe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startInetent = new Intent(getApplicationContext(), Ribe.class);
                startActivities(new Intent[]{startInetent});
            }
        });

        Button biljke = (Button)findViewById(R.id.biljkeBtn);
        biljke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startInetent = new Intent(getApplicationContext(), Biljke.class);
                startActivities(new Intent[]{startInetent});
            }
        });
    }
}
