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

import java.util.ArrayList;

import br.com.senaicimatec.capiraffle.R;
import br.com.senaicimatec.capiraffle.models.DezenasModel;
import br.com.senaicimatec.capiraffle.adapter.GridAdapter;

public class RifaFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_rifa, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Instanciar todos os objetos
        ArrayList<DezenasModel> dezenasModelArrayList = new ArrayList<>();

        TextView rifaTitulo, rifaCriador, rifaPremio, rifaData;
        GridView gridView;
        Button compraBtn;

        rifaTitulo = view.findViewById(R.id.rifaFragTitulo);
        rifaCriador = view.findViewById(R.id.rifaFragCriador);
        rifaPremio = view.findViewById(R.id.rifaFragPremio);
        rifaData = view.findViewById(R.id.rifaFragData);
        gridView = view.findViewById(R.id.griView);
        compraBtn = view.findViewById(R.id.btnCompra);

        GridAdapter gridAdapter = new GridAdapter(getContext(), dezenasModelArrayList);

        // Preencher o array
        for(int i = 1; i <= 50; i++){
            String num = Integer.toString(i);
            DezenasModel dezenasModel = new DezenasModel(num);
            dezenasModelArrayList.add(dezenasModel);
        }

        // Request da API para definir os valores ja marcados

        // Setar o adapter
        gridView.setAdapter(gridAdapter);

        // Lista para armazenar os numeros clicados pelo usuario
        // Enviar lista para o banco
        ArrayList<String> listaDezenas = gridAdapter.getListDezenas();

        // Bloco dos dados textuais


        //Bloco do Button
        compraBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Bundle -> listaNumeros, o id da rifa
                // Mudar tela e enviar o bundle
                Navigation.findNavController(view).navigate(R.id.action_rifaFragment_to_compraFragment);
            }
        });
    }
}