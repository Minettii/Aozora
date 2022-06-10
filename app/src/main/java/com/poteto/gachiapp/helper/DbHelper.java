package com.poteto.gachiapp.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {

    public static int VERSION = 1;
    public static String DB_NAME = "gachiDB";

    //Also default in DB
    public static int DEFAULT_CUSTOM_TRUE = 1;
    public static int CARD_DEFAULT_LAST_DATE = -1;
    public static int CARD_DEFAULT_NEXT_DATE = -1;
    public static int DEFAULT_ACTIVE_FALSE = 0;


    //Default insert when the Model object correspondent variable was not initialized (on setter)
    public static String CARD_DEFAULT_READING = "";
    public static String CARD_DEFAULT_EXAMPLE = "";
    public static String CARD_DEFAULT_EX_FURIGANA = "";
    public static String CARD_DEFAULT_EX_TRANSLATION = "";

    public static int CUSTOM_FALSE = 0;
    public static int ACTIVE_TRUE = 1;


    //TABLE deck
    public static String TABLE_DECK = "deck";
    public static String DECK_ID = "id";
    public static String DECK_NAME = "name";
    public static String DECK_CUSTOM = "custom";


    //TABLE card
    public static String TABLE_CARD = "card";
    public static String CARD_ID = "id";
    public static String CARD_FRONT = "front";
    public static String CARD_BACK = "back";
    public static String CARD_READING = "reading";
    public static String CARD_EXAMPLE = "example";
    public static String CARD_EX_FURIGANA = "ex_furigana";
    public static String CARD_EX_TRANSLATION = "ex_translation";
    public static String CARD_SCORE = "score";
    public static String CARD_NEXT_DATE = "next_date";
    public static String CARD_LAST_DATE = "last_date";
    public static String CARD_DECK = "deck";
    public static String CARD_ACTIVE = "active";



    public DbHelper(Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
