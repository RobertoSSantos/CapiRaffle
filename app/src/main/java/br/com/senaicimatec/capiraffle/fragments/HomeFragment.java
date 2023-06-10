package br.com.senaicimatec.capiraffle.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import br.com.senaicimatec.capiraffle.R;
import br.com.senaicimatec.capiraffle.models.RifaModel;
import br.com.senaicimatec.capiraffle.adapter.ListAdapter;

public class HomeFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ArrayList<RifaModel> rifaModelArrayList =new ArrayList<>();

        // Para testes
        RifaModel rifa1 = new RifaModel(1, "Rifa relogio", "Nicoboco", "relogio", "12/07");
        rifaModelArrayList.add(rifa1);
        /*
        Implementar logica para receber os dados do banco, criar os objetos e adicionar eles ao array list.
         */

        FloatingActionButton cadFab = view.findViewById(R.id.cadFab);
        ListView listaRifas =view.findViewById(R.id.rifaLista);
        ListAdapter listAdapter= new ListAdapter(getContext(),rifaModelArrayList);

        listaRifas.setAdapter(listAdapter);

        listaRifas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_rifaFragment);
            }
        });

        cadFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_cadastrarRifaFragment);
            }
        });
    }
}