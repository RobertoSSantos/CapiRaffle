package br.com.senaicimatec.capiraffle.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import br.com.senaicimatec.capiraffle.database.Database;
import br.com.senaicimatec.capiraffle.models.CompradorModel;
import br.com.senaicimatec.capiraffle.models.RifaModel;

public class CompradorDao {
    private Database database;
    private SQLiteDatabase capiDatabase;

    public CompradorDao(Context context){
        database = new Database(context);
        capiDatabase = database.getWritableDatabase();
    }

    public long inserirComprador(CompradorModel compradorModel){
        ContentValues values = new ContentValues();

        values.put("nomeComprador",compradorModel.getNomeComprador() );
        values.put("cpfComprador", compradorModel.getCpfComprador());
        values.put("dezenas", compradorModel.getDezenas());
        values.put("idRifa", compradorModel.getIdRifa());

        return capiDatabase.insert("comprador",null,values);
    }

    public ArrayList<String> consultarDezenas(String idParam){
        ArrayList<String> dezenas = new ArrayList<>();
        String dezena = "";

        String consulta = "SELECT * FROM comprador WHERE idRifa = ?";
        String[] argumentos = {idParam};

        Cursor cursor = capiDatabase.rawQuery(consulta, argumentos);

        if (cursor != null && cursor.moveToFirst()) {
            int indexColuna = cursor.getColumnIndex("dezenas");
            do{
                dezena = cursor.getString(indexColuna);
                dezenas.add(dezena);
            } while (cursor.moveToNext());

        }

        if (cursor != null) {
            cursor.close();
        }

        return dezenas;
    }
}
