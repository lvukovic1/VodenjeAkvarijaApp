package com.akvarij.ldk.main.akvarij;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.akvarij.ldk.main.baza.NitratiBaza;
import com.akvarij.ldk.main.glavna.R;
import com.jjoe64.graphview.DefaultLabelFormatter;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Nitrati extends AppCompatActivity {
    Button nitratiIzracunBtn;
    EditText nitratiUnos1;

    GraphView graph;
    LineGraphSeries<DataPoint> series= new LineGraphSeries<>(new DataPoint[0]);
    NitratiBaza nitratiBaza;
    SQLiteDatabase sqLiteDatabase;
    SimpleDateFormat sdf= new SimpleDateFormat("hh:mm:ss a");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nitrati2);

        nitratiIzracunBtn = (Button) findViewById(R.id.nitratiIzracunBtn);
        nitratiUnos1 =  (EditText) findViewById(R.id.nitratiUnos1);
        graph = (GraphView) findViewById(R.id.graph);


        nitratiBaza = new NitratiBaza(this);
        sqLiteDatabase = nitratiBaza.getWritableDatabase();

        graph.addSeries(series);

        exqInsert();






    }

    private void exqInsert() {
        nitratiIzracunBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                long xValue = new Date().getTime();
                int yValue = Integer.parseInt(String.valueOf(nitratiUnos1.getText()));

                nitratiBaza.insertData(xValue,yValue);

                series.resetData(getDataPoint());
                graph.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter(){
                    @Override
                    public String formatLabel(double value, boolean isValueX) {
                       if(isValueX){
                           return sdf.format(new Date((long)value));
                       }else {
                           return super.formatLabel(value, isValueX);
                       }}
                });
            }
        });
    }

    private DataPoint[] getDataPoint() {
        String[] columns={"xValues","yValues"};
        Cursor cursor = sqLiteDatabase.query("MyTable",columns,null,null,null,null,null);
        DataPoint[] dp= new DataPoint[cursor.getCount()];

        for(int i=0;i<cursor.getCount();i++){
            cursor.moveToNext();
            dp[i] = new DataPoint(cursor.getLong(0),cursor.getInt(1));
        }
        return dp;
    }


}
