package com.example.contatos.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "contatos_db";
    private static final int DATABASE_VERSION = 2;

    public static final String TABLE_CONTATOS_NAME = "contatos";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NOME = "nome";

    private static final String CREATE_TABLE_CONTATOS =
            "CREATE TABLE IF NOT EXISTS " + TABLE_CONTATOS_NAME + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_NOME + " TEXT NOT NULL" +
                    ")";

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_CONTATOS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTATOS_NAME);
//        onCreate(db);
    }
}
