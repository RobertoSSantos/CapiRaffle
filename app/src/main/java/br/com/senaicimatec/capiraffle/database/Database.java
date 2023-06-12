package br.com.senaicimatec.capiraffle.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {

    private static final String db_name = "capiDatabase";
    private static  final int db_version = 2;


    public Database(Context context){
        super(context, db_name, null, db_version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        StringBuilder rifaTable, compradorTable;
        rifaTable = new StringBuilder()
                .append("CREATE TABLE IF NOT EXISTS ")
                .append("rifa(")
                .append("id INTEGER PRIMARY KEY autoincrement,")
                .append("nomeCriador VARCHAR(50),")
                .append("cpfCriador VARCHAR(50),")
                .append("chavePixCriador VARCHAR(50),")
                .append("titulo VARCHAR(50),")
                .append("premio VARCHAR(50),")
                .append("valNum VARCHAR(50),")
                .append("dataFinal VARCHAR(50) )");

        compradorTable = new StringBuilder()
                .append("CREATE TABLE IF NOT EXISTS ")
                .append("comprador(")
                .append("id INTEGER PRIMARY KEY autoincrement,")
                .append("nomeComprador VARCHAR(50),")
                .append("cpfComprador VARCHAR(50),")
                .append("dezenas VARCHAR(50),")
                .append("idRifa INTEGER )");

        sqLiteDatabase.execSQL(rifaTable.toString());
        sqLiteDatabase.execSQL(compradorTable.toString());
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        StringBuilder rifaTable, compradorTable;
        rifaTable = new StringBuilder()
                .append("CREATE TABLE IF NOT EXISTS ")
                .append("rifa(")
                .append("id INTEGER PRIMARY KEY autoincrement,")
                .append("nomeCriador VARCHAR(50),")
                .append("cpfCriador VARCHAR(50),")
                .append("chavePixCriador VARCHAR(50),")
                .append("titulo VARCHAR(50),")
                .append("premio VARCHAR(50),")
                .append("valNum VARCHAR(50),")
                .append("dataFinal VARCHAR(50) )");

        compradorTable = new StringBuilder()
                .append("CREATE TABLE IF NOT EXISTS ")
                .append("comprador(")
                .append("id INTEGER PRIMARY KEY autoincrement,")
                .append("nomeComprador VARCHAR(50),")
                .append("cpfComprador VARCHAR(50),")
                .append("dezenas VARCHAR(50),")
                .append("idRifa INTEGER )");

        sqLiteDatabase.execSQL(rifaTable.toString());
        sqLiteDatabase.execSQL(compradorTable.toString());
    }
}
