package com.akvarij.ldk.main.financije;

import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.akvarij.ldk.main.glavna.R;

import de.codecrafters.tableview.TableView;
import de.codecrafters.tableview.listeners.TableDataClickListener;
import de.codecrafters.tableview.toolkit.SimpleTableDataAdapter;
import de.codecrafters.tableview.toolkit.SimpleTableHeaderAdapter;

public class Main2Activity extends AppCompatActivity {

    EditText nameEditText,propellantEditTxt,destEditTxt;
    Button saveBtn;
    TableView<String[]> tb;
    TableHelper tableHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //TABLEVIEW
        tableHelper=new TableHelper(this);
        tb = (TableView<String[]>) findViewById(R.id.tableView);
        tb.setColumnCount(2);
        tb.setHeaderBackgroundColor(Color.parseColor("#2ecc71"));
        tb.setHeaderAdapter(new SimpleTableHeaderAdapter(this,tableHelper.getSpaceProbeHeaders()));
        tb.setDataAdapter(new SimpleTableDataAdapter(this, tableHelper.getSpaceProbes()));

        //TABLE CLICK
        tb.addDataClickListener(new TableDataClickListener() {
            @Override
            public void onDataClicked(int rowIndex, Object clickedData) {
                Toast.makeText(Main2Activity.this, ((String[])clickedData)[1], Toast.LENGTH_SHORT).show();
            }
        });


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayDialog();
            }
        });
    }


    /*
    DISPLAY INPUT DIALOG
    SAVE
     */
    private void displayDialog()
    {
        Dialog d=new Dialog(this);
        d.setTitle("SQLITE DATA");
        d.setContentView(R.layout.dialog_layout);

        //INITIALIZE VIEWS
        nameEditText= (EditText) d.findViewById(R.id.nameEditTxt);
        propellantEditTxt= (EditText) d.findViewById(R.id.propEditTxt);
        destEditTxt= (EditText) d.findViewById(R.id.destEditTxt);

        saveBtn= (Button) d.findViewById(R.id.saveBtn);


        //SAVE
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Spacecraft s = new Spacecraft();
                s.setName(nameEditText.getText().toString());
                s.setPropellant(propellantEditTxt.getText().toString());
                s.setDestination(destEditTxt.getText().toString());


                if (new DBAdapter(Main2Activity.this).saveSpacecraft(s)) {
                    nameEditText.setText("");
                    propellantEditTxt.setText("");
                    destEditTxt.setText("");

                    tb.setDataAdapter(new SimpleTableDataAdapter(Main2Activity.this, tableHelper.getSpaceProbes()));

                } else {
                    Toast.makeText(Main2Activity.this, "Not Saved", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //SHOW DIALOG
        d.show();


    }

}
