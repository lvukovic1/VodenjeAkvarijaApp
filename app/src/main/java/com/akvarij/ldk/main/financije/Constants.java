package com.akvarij.ldk.main.financije;

public class Constants {
    /*
  COLUMNS
   */
    static final String ROW_ID="id";
    static final String NAME="name";
    static final String PROPELLANT="propellant";
    static final String DESTINATION="destination";


    /*
    DB PROPERTIES
     */
    static final String DB_NAME="tv_DB";
    static final String TB_NAME="tv_TB";
    static final int DB_VERSION=1;

    /*
    TABLE CREATION STATEMENT
     */
    static final String CREATE_TB="CREATE TABLE tv_TB(id INTEGER PRIMARY KEY AUTOINCREMENT,"
            + "name TEXT NOT NULL,propellant TEXT NOT NULL,destination TEXT NOT NULL);";


    /*
    TABLE DELETION STMT
     */
    static final String DROP_TB="DROP TABLE IF EXISTS "+TB_NAME;

}
