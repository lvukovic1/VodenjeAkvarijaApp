package com.akvarij.ldk.main.glavna;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.akvarij.ldk.main.financije.BZVZ;
import com.akvarij.ldk.main.financije.Kupljeno;
import com.akvarij.ldk.main.financije.Prodano;
import com.akvarij.ldk.main.izracuni.Litraza;

public class PracenjeFinancija extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pracenje_financija);


        Button kupljeno = (Button)findViewById(R.id.kupljenoBtn);
        kupljeno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startInetent = new Intent(getApplicationContext(), Kupljeno.class);
                startActivities(new Intent[]{startInetent});
            }
        });


        Button prodano = (Button)findViewById(R.id.prodanoBtn);
        prodano.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startInetent = new Intent(getApplicationContext(), BZVZ.class);
                startActivities(new Intent[]{startInetent});
            }
        });
    }
}
