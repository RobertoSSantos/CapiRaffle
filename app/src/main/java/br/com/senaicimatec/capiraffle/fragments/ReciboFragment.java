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
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

import br.com.senaicimatec.capiraffle.R;

public class ReciboFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recibo, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView reciboComprador, reciboCpf, reciboNums, reciboRifa;
        Button concluirBtn;

        //Recebendo todos os dados enviados pelo bundle
        String nomeComprador = getArguments().getString("nomeComprador");
        String cpfComprador = getArguments().getString("cpfComprador");
        String nomeRifa = getArguments().getString("tituloRifa");
        ArrayList<String> data = new ArrayList<>(Arrays.asList(getArguments().getStringArray("dezenas")));

        reciboComprador = view.findViewById(R.id.reciboComprador);
        reciboCpf = view.findViewById(R.id.reciboCpf);
        reciboNums = view.findViewById(R.id.reciboNums);
        reciboRifa = view.findViewById(R.id.reciboRifa);
        concluirBtn = view.findViewById(R.id.concluirBtn);

        // Set das TVs
        reciboComprador.setText(nomeComprador);
        reciboCpf.setText(cpfComprador);
        reciboNums.setText(data.toString());
        reciboRifa.setText(nomeRifa);

        concluirBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_reciboFragment_to_homeFragment);
            }
        });
    }
}