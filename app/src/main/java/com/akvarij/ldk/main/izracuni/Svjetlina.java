package com.akvarij.ldk.main.izracuni;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.akvarij.ldk.main.glavna.R;

public class Svjetlina extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_svjetlina);

// izracun svjetlina
        Button svjetlinaBtn = (Button) findViewById(R.id.svjetlinaBtn);
        svjetlinaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText svjetlinaEditText = (EditText) findViewById(R.id.svjetlinaEditText);
                TextView svjetlinaTextView = (TextView) findViewById(R.id.svjetlinaTextView);

                CheckBox malocheckBox = (CheckBox) findViewById(R.id.malocheckBox);
                CheckBox srednjecheckBox = (CheckBox) findViewById(R.id.srednjecheckBox);
                CheckBox punocheckBox = (CheckBox) findViewById(R.id.punocheckBox);

                int svjetlina=Integer.parseInt(svjetlinaEditText.getText().toString());
                int rezultat;

                if (malocheckBox.isChecked()== true && srednjecheckBox.isChecked()==true || malocheckBox.isChecked()== true && punocheckBox.isChecked()==true
                        || srednjecheckBox.isChecked()== true && punocheckBox.isChecked()==true ){
                    svjetlinaTextView.setText("Odaberite samo jedno od ponudenoga !");
                }
                else if (malocheckBox.isChecked()== true) {
                    rezultat = svjetlina * 15;
                    svjetlinaTextView.setText(rezultat + "");
                }
                else if (srednjecheckBox.isChecked()== true){
                    rezultat =svjetlina*25;
                    svjetlinaTextView.setText(rezultat + "");
                }
                else if (punocheckBox.isChecked()== true){
                    rezultat =svjetlina*40;
                    svjetlinaTextView.setText(rezultat + "");
                }



                else {
                    svjetlinaTextView.setText("Odaberite jedno od ponudenoga !");
                }

            }
        });
    }
}
