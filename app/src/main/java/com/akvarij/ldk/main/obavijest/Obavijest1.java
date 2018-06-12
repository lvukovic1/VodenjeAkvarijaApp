package com.akvarij.ldk.main.obavijest;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.provider.AlarmClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.akvarij.ldk.main.glavna.R;

import java.util.Calendar;

public class Obavijest1 extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_obavijest1);


        Button button =(Button) findViewById(R.id.hranjenje);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM);
                intent.putExtra(AlarmClock.EXTRA_HOUR,13);
                intent.putExtra(AlarmClock.EXTRA_MINUTES,20);
                intent.putExtra(AlarmClock.EXTRA_MESSAGE,"Hranjenje ribica");
                intent.putExtra(AlarmClock.EXTRA_DAYS,30);
                startActivity(intent);
            }
        });

    }
}