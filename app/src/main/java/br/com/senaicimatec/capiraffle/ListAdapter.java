package br.com.senaicimatec.capiraffle;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<RifaModel> {

    public ListAdapter(@NonNull Context context, ArrayList<RifaModel> rifaModelArrayList) {
        super(context, R.layout.raffle_item_card, rifaModelArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View view, @NonNull ViewGroup parent) {
        RifaModel rifaModel = getItem(position);

        if(view == null){
            view = LayoutInflater.from(getContext()).inflate(R.layout.raffle_item_card, parent, false);
        }

        // Setup do Cartao
        TextView tituloItem, nomeCriadorItem, premioItem, dataFinalItem;

        tituloItem = view.findViewById(R.id.tituloRifa);
        nomeCriadorItem = view.findViewById(R.id.criadorRifa);
        premioItem = view.findViewById(R.id.premioRifa);
        dataFinalItem = view.findViewById(R.id.dataRifa);

        tituloItem.setText(rifaModel.getTitulo());
        nomeCriadorItem.setText(rifaModel.getNomeCriador());
        premioItem.setText(rifaModel.getPremio());
        dataFinalItem.setText(rifaModel.getDataFinal());

        return view;
    }
}
