package com.akvarij.ldk.main.financije;

import android.content.Context;

import java.util.ArrayList;

public class TableHelper {

    //DECLARATIONS
    Context c;
    private String[] spaceProbeHeaders={"Naziv artikla","Cijena artikla"};
    private String[][] spaceProbes;

    //CONSTRUCTOR
    public TableHelper(Context c) {
        this.c = c;
    }

    //RETURN TABLE HEADERS
    public String[] getSpaceProbeHeaders()
    {
        return spaceProbeHeaders;
    }

    //RETURN TABLE ROWS
    public  String[][] getSpaceProbes()
    {
        ArrayList<Spacecraft> spacecrafts=new DBAdapter(c).retrieveSpacecrafts();
        Spacecraft s;

        spaceProbes= new String[spacecrafts.size()][3];

        for (int i=0;i<spacecrafts.size();i++) {

            s=spacecrafts.get(i);

            spaceProbes[i][0]=s.getName();
            spaceProbes[i][1]=s.getPropellant();
            spaceProbes[i][2]=s.getDestination();
        }

        return spaceProbes;





    }
}
