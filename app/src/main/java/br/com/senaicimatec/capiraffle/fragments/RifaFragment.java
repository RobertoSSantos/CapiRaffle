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
import br.com.senaicimatec.capiraffle.dao.CompradorDao;
import br.com.senaicimatec.capiraffle.dao.RifaDao;
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

        RifaDao rifaDao = new RifaDao(getContext());
        CompradorDao compradorDao = new CompradorDao(getContext());
        ArrayList<DezenasModel> dezenasModelArrayList = new ArrayList<>();

        int id = getArguments().getInt("id");
        ArrayList<String> arrayDezenas = compradorDao.consultarDezenas(Integer.toString(id));

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


        for(int i = 1; i <= 50; i++){
            String num = Integer.toString(i);
            DezenasModel dezenasModel = new DezenasModel(num);
            dezenasModelArrayList.add(dezenasModel);
        }

        for (DezenasModel dezena : dezenasModelArrayList) {
            if (arrayDezenas.contains(dezena.getDezena())) {
                dezena.setCondicao(false);
            }
        }

        GridAdapter gridAdapter = new GridAdapter(getContext(), dezenasModelArrayList);

        gridView.setAdapter(gridAdapter);

        RifaModel rifaModel = rifaDao.consultarRifa(Integer.toString(id));
        Bundle bundle = new Bundle();

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
                    StringBuilder builder = new StringBuilder();
                    for (String item : listaDezenas) {
                        if (builder.length() > 0) {
                            builder.append(", ");
                        }
                        builder.append(item);
                    }

                    String dezenas = builder.toString();

                    bundle.putString("dezenas", dezenas);
                    bundle.putString("chavePixCriador", rifaModel.getChavePixCriador());
                    bundle.putString("tituloRifa", rifaModel.getTitulo());
                    bundle.putInt("id",id);

                    Navigation.findNavController(view).navigate(R.id.action_rifaFragment_to_compraFragment,bundle);
                } else {
                    Toast.makeText(getContext(), "Selecione pelo menos um numero", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}