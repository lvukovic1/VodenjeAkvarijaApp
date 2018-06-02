package com.akvarij.ldk.main.glavna;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.akvarij.ldk.main.financije.Prodano;
import com.akvarij.ldk.main.flora_fauna.Biljke;
import com.akvarij.ldk.main.flora_fauna.Ribe;

import java.net.URI;

public class PregledFloreFaune extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        Button ribe = (Button)findViewById(R.id.ribeBtn);
        ribe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ribeurl = "http://www.akvarij.net/index.php/a381ivorotke-menuslatkovodnaribe-54";
                Uri webaddress = Uri.parse(ribeurl);

                Intent gotoribe = new Intent(Intent.ACTION_VIEW, webaddress);
                if(gotoribe.resolveActivity(getPackageManager()) !=null);
                startActivity(gotoribe);

                //Intent startInetent = new Intent(getApplicationContext(), Ribe.class);
                //startActivities(new Intent[]{startInetent});
            }
        });

        Button biljke = (Button)findViewById(R.id.biljkeBtn);
        biljke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String biljkeurl = "http://www.akvarij.net/index.php/slatkovodna-akvaristika-othermenu-43/biljke-othermenu-45";
                Uri webaddress = Uri.parse(biljkeurl);

                Intent gotobiljke = new Intent(Intent.ACTION_VIEW, webaddress);
                if(gotobiljke.resolveActivity(getPackageManager()) !=null);
                startActivity(gotobiljke);
                //Intent startInetent = new Intent(getApplicationContext(), Biljke.class);
                //startActivities(new Intent[]{startInetent});
            }
        });
    }
}
