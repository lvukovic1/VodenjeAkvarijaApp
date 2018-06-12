package com.akvarij.ldk.main.glavna;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.akvarij.ldk.main.obavijest.Obavijest1;


public class MainActivity extends AppCompatActivity {

    private DrawerLayout nDrawerLayout;
    private ActionBarDrawerToggle nToggle;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        nToggle = new ActionBarDrawerToggle(this,nDrawerLayout, R.string.open,R.string.close );

        nDrawerLayout.addDrawerListener(nToggle);
        nToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);





        NavigationView nv = (NavigationView)findViewById(R.id.nv1);
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case(R.id.nav_floraFauna):
                        Intent in = new Intent(getApplicationContext(),PregledFloreFaune.class);
                        startActivity(in);
                        break;
                    case(R.id.nav_izracuni):
                        in = new Intent(getApplicationContext(),Izracunavanje.class);
                        startActivity(in);
                        break;
                    case(R.id.nav_obavijesti):
                        in = new Intent(getApplicationContext(),Obavijest1.class);
                        startActivity(in);
                        break;
                    case(R.id.nav_pracenjeFinancija):
                        in = new Intent(getApplicationContext(),PracenjeFinancija.class);
                        startActivity(in);
                        break;
                    case(R.id.nav_stanjeAkvarija):
                        in = new Intent(getApplicationContext(),PracenjeStanjaAkvarija.class);
                        startActivity(in);
                }
                return true;
            }
        });





    }




    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(nToggle.onOptionsItemSelected(item)){
            return true;
        }


        return super.onOptionsItemSelected(item);
    }
}
