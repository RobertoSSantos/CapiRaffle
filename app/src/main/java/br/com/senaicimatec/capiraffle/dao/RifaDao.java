package br.com.senaicimatec.capiraffle.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import br.com.senaicimatec.capiraffle.database.Database;
import br.com.senaicimatec.capiraffle.models.RifaModel;

public class RifaDao {

    private Database database;
    private SQLiteDatabase capiDatabase;

    public RifaDao(Context context){
        database = new Database(context);
        capiDatabase = database.getWritableDatabase();
    }

    public long inserirRifa(RifaModel rifaModel){
        ContentValues values = new ContentValues();

        values.put("nomeCriador", rifaModel.getNomeCriador());
        values.put("cpfCriador", rifaModel.getCpfCriador());
        values.put("chavePixCriador", rifaModel.getChavePixCriador());
        values.put("titulo", rifaModel.getTitulo());
        values.put("premio", rifaModel.getPremio());
        values.put("valNum", rifaModel.getValNum());
        values.put("dataFinal", rifaModel.getDataFinal());

        return capiDatabase.insert("rifa",null,values);
    }

    public List<RifaModel> listarRifas(){
        List<RifaModel> listaRifas = new ArrayList<>();

        Cursor cursor = capiDatabase.query("rifa",
                new String[]{"id","nomeCriador","cpfCriador","chavePixCriador","titulo", "premio", "valNum", "dataFinal"},
                null, null, null, null,null);

        while (cursor.moveToNext()){
            RifaModel rifa = new RifaModel();

            rifa.setId(cursor.getInt(0));
            rifa.setNomeCriador(cursor.getString(1));
            rifa.setCpfCriador(cursor.getString(2));
            rifa.setChavePixCriador(cursor.getString(3));
            rifa.setTitulo(cursor.getString(4));
            rifa.setPremio(cursor.getString(5));
            rifa.setValNum(cursor.getString(6));
            rifa.setDataFinal(cursor.getString(7));

            listaRifas.add(rifa);
        }
        cursor.close();
        return listaRifas;
    }

    public int consultarIdRifa(String idParam) {
        int id = 0;
        String consulta = "SELECT id FROM rifa WHERE id = ?";
        String[] argumentos = { idParam };

        Cursor cursor = capiDatabase.rawQuery(consulta, argumentos);

        if (cursor.moveToFirst()){
            do{
                id = cursor.getInt(0);
            }while (cursor.moveToNext());
        }

        cursor.close();
        return id+1;
    }

    public RifaModel consultarRifa(String idParam){
        RifaModel rifa = new RifaModel();
        String consulta = "SELECT * FROM rifa WHERE id = ?";
        String[] argumentos = {idParam};

        Cursor cursor = capiDatabase.rawQuery(consulta, argumentos);

        if (cursor.moveToFirst()){
            do{
                rifa.setId(cursor.getInt(0));
                rifa.setNomeCriador(cursor.getString(1));
                rifa.setCpfCriador(cursor.getString(2));
                rifa.setChavePixCriador(cursor.getString(3));
                rifa.setTitulo(cursor.getString(4));
                rifa.setPremio(cursor.getString(5));
                rifa.setValNum(cursor.getString(6));
                rifa.setDataFinal(cursor.getString(7));
            }while (cursor.moveToNext());
        }
        cursor.close();
        return rifa;
    }
}
