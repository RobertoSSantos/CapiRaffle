package br.com.senaicimatec.capiraffle.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import br.com.senaicimatec.capiraffle.R;
import br.com.senaicimatec.capiraffle.models.DezenasModel;
import br.com.senaicimatec.capiraffle.adapter.GridAdapter;
import br.com.senaicimatec.capiraffle.models.RifaModel;

public class RifaFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_rifa, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ArrayList<DezenasModel> dezenasModelArrayList = new ArrayList<>();

        TextView rifaTitulo, rifaCriador, rifaPremio, rifaValNum, rifaData;
        GridView gridView;
        Button compraBtn;

        rifaTitulo = view.findViewById(R.id.rifaFragTitulo);
        rifaCriador = view.findViewById(R.id.rifaFragCriador);
        rifaPremio = view.findViewById(R.id.rifaFragPremio);
        rifaValNum = view.findViewById(R.id.rifaFragValorNum);
        rifaData = view.findViewById(R.id.rifaFragData);
        gridView = view.findViewById(R.id.griView);
        compraBtn = view.findViewById(R.id.btnCompra);

        GridAdapter gridAdapter = new GridAdapter(getContext(), dezenasModelArrayList);

        for(int i = 1; i <= 50; i++){
            String num = Integer.toString(i);
            DezenasModel dezenasModel = new DezenasModel(num);
            dezenasModelArrayList.add(dezenasModel);
        }

        // Request da API para definir os valores ja marcados


        gridView.setAdapter(gridAdapter);

        RifaModel rifaModel = new RifaModel();
        Bundle bundle = new Bundle();

        /*
        Logica para receber os dados da rifa do banco e fazer os sets para o objeto
         */

        rifaTitulo.setText(rifaModel.getTitulo());
        rifaCriador.setText(rifaModel.getNomeCriador());
        rifaPremio.setText(rifaModel.getPremio());
        rifaValNum.setText(rifaModel.getValNum());
        rifaData.setText(rifaModel.getDataFinal());

        ArrayList<String> listaDezenas = gridAdapter.getListDezenas();
        compraBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(listaDezenas != null){
                    String[] arrayDezenas = listaDezenas.toArray(new String[listaDezenas.size()]);
                    bundle.putStringArray("dezenas", arrayDezenas);
                    //bundle.putString("chavePixCriador", rifaModel.getChavePixCriador());
                    //bundle.putString("tituloRifa", rifaModel.getTitulo());
                    Navigation.findNavController(view).navigate(R.id.action_rifaFragment_to_compraFragment,bundle);
                } else {
                    Toast.makeText(getContext(), "Selecione pelo menos um numero", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}