package com.akvarij.ldk.main.akvarij;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.akvarij.ldk.main.baza.PHBaza;
import com.akvarij.ldk.main.glavna.R;
import com.jjoe64.graphview.DefaultLabelFormatter;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PHVrijednosti extends AppCompatActivity {
    Button PHIzracunBtn;
    EditText PHUnos1;

    GraphView graphPH;
    LineGraphSeries<DataPoint> series= new LineGraphSeries<>(new DataPoint[0]);
    PHBaza phbaza;
    SQLiteDatabase sqLiteDatabase;
    SimpleDateFormat sdf= new SimpleDateFormat("ww");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phvrijednosti);


        PHIzracunBtn = (Button) findViewById(R.id.TempIzracunBtn);
        PHUnos1 =  (EditText) findViewById(R.id.PHUnos1);
        graphPH = (GraphView) findViewById(R.id.graphTemp);


        phbaza = new PHBaza(this);
        sqLiteDatabase = phbaza.getWritableDatabase();

        graphPH.addSeries(series);

        exqInsert();






    }

    private void exqInsert() {
        PHIzracunBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                long xValue = new Date().getTime();
                int yValue = Integer.parseInt(String.valueOf(PHUnos1.getText()));

                phbaza.insertData(xValue,yValue);

                series.resetData(getDataPoint());
                graphPH.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter(){
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

