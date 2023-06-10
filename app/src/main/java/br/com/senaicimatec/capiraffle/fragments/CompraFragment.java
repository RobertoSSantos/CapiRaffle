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
import android.widget.EditText;
import android.widget.TextView;

import br.com.senaicimatec.capiraffle.R;

public class CompraFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_compra, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        EditText nomeComprador, cpfComprador;
        TextView numsTv, pixTv;
        Button finalizarCompraBtn;

        nomeComprador = view.findViewById(R.id.cadastroNomeComprador);
        cpfComprador = view.findViewById(R.id.cadastroCpfComprador);
        numsTv = view.findViewById(R.id.textNumeros);
        pixTv = view.findViewById(R.id.textChavePix);
        finalizarCompraBtn = view.findViewById(R.id.finalCompraBtn);

        // Pegar os dados dos EDTs

        // Setar os dados para os TVs

        // OnClick do BTN
        finalizarCompraBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_compraFragment_to_reciboFragment);
            }
        });

    }
}