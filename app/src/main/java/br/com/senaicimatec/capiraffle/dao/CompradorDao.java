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
        values.put("numSelecionados", compradorModel.getNumselecionados());
        values.put("idRifa", compradorModel.getIdRifa());

        return capiDatabase.insert("comprador",null,values);
    }

    public ArrayList<String> consultaDezenas(String idRifa){
        ArrayList<String> stringArrayList = new ArrayList<>();

        String consulta = "SELECT numSelecionados FROM comprador WHERE idRifa = ?";
        String[] argumentos = { idRifa };

        Cursor cursor = capiDatabase.rawQuery(consulta, argumentos);

        if (cursor.moveToFirst()){
            do{
                String dezenaSel = cursor.getString(3);
                stringArrayList.add(dezenaSel);
            }while (cursor.moveToNext());
        }

        cursor.close();
        return stringArrayList;
    }

    public String consultarNum(String idRifa){
        String dezenaSel = "";
        String consulta = "SELECT numSelecionados FROM comprador WHERE idRifa = ?";
        String[] argumentos = { idRifa };

        Cursor c = capiDatabase.rawQuery(consulta, argumentos);

        if (c.moveToFirst()){
            do{
                dezenaSel = c.getString(3);
            }while (c.moveToNext());
        }
        c.close();
        return dezenaSel;
    }
}
