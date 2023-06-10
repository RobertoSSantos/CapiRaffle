package br.com.senaicimatec.capiraffle.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;

import java.util.ArrayList;

import br.com.senaicimatec.capiraffle.modules.DezenasModel;
import br.com.senaicimatec.capiraffle.R;

public class GridAdapter extends ArrayAdapter<DezenasModel> {

    ArrayList<String> listDezenas = new ArrayList<>();

    public GridAdapter(@NonNull Context context, ArrayList<DezenasModel> dezenasModelArrayList) {
        super(context,0, dezenasModelArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        int verdeLivre = Color.parseColor("#2aa84c");
        int vermelhoFechado = Color.parseColor("#a82a2a");

        View gridItemView = convertView;
        if (gridItemView == null) {
            gridItemView = LayoutInflater.from(getContext()).inflate(R.layout.grid_item, parent, false);
        }

        DezenasModel dezenasModel = getItem(position);

        CardView cardBackground = gridItemView.findViewById(R.id.dezenaCard);
        TextView cardValue = gridItemView.findViewById(R.id.dezenaValue);

        // Todas as acoes necessarias da grid
        cardValue.setText(dezenasModel.getDezena());

        if(dezenasModel.getCondicao()){
            cardBackground.setCardBackgroundColor(verdeLivre);
        }
        else {
            cardBackground.setCardBackgroundColor(vermelhoFechado);
        }

        gridItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(dezenasModel.getCondicao()){
                    cardBackground.setCardBackgroundColor(vermelhoFechado);
                    dezenasModel.setCondicao(false);
                    listDezenas.add(dezenasModel.getDezena());
                }
                else {
                    Toast.makeText(getContext(), "Dezena ja selecionada", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return gridItemView;
    }

    public ArrayList<String> getListDezenas(){
        return listDezenas;
    }
}
