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

import br.com.senaicimatec.capiraffle.R;

public class ReciboFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recibo, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView reciboComprador, reciboCpf, reciboNums, reciboRifa;
        Button concluirBtn;

        reciboComprador = view.findViewById(R.id.reciboComprador);
        reciboCpf = view.findViewById(R.id.reciboCpf);
        reciboNums = view.findViewById(R.id.reciboNums);
        reciboRifa = view.findViewById(R.id.reciboRifa);
        concluirBtn = view.findViewById(R.id.concluirBtn);

        // Setar as TVs

        concluirBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_reciboFragment_to_homeFragment);
            }
        });
    }
}