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
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

import br.com.senaicimatec.capiraffle.R;
import br.com.senaicimatec.capiraffle.models.CompradorModel;

public class CompraFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_compra, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        EditText nomeComprador, cpfComprador;
        TextView numsTv, pixTv;
        Button finalizarCompraBtn;

        Bundle bundle = new Bundle();
        CompradorModel compradorModel = new CompradorModel();

        // apenas armazena o valor do titulo para repassa-lo para o proximo fragmento
        //String tituloRifa = getArguments().getString("tituloRifa");
        //String chavePix = getArguments().getString("chavePixCriador");
        ArrayList<String> data = new ArrayList<>(Arrays.asList(getArguments().getStringArray("dezenas")));

        nomeComprador = view.findViewById(R.id.cadastroNomeComprador);
        cpfComprador = view.findViewById(R.id.cadastroCpfComprador);
        numsTv = view.findViewById(R.id.textNumeros);
        pixTv = view.findViewById(R.id.textChavePix);
        finalizarCompraBtn = view.findViewById(R.id.finalCompraBtn);

        EditText[] editTexts = {nomeComprador, cpfComprador};

        // Seta o texto do campo das dezenas selecionadas, a partir dos dados recebidos do outro fragmento
        numsTv.setText(data.toString());

        // Seta o texto do campo da chave pix, a partir dos dados recebidos do outro fragmento
        //pixTv.setText(chavePix);

        finalizarCompraBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Verificando se existem valores nulos
                boolean todosCamposPreenchidos = true;
                for (EditText editText : editTexts){
                    if (editText.getText().toString().isEmpty()) {
                        todosCamposPreenchidos = false;
                        break;
                    }
                }

                if (!todosCamposPreenchidos){
                    Toast.makeText(getContext(), "Preencha todos os campos corretamente", Toast.LENGTH_SHORT).show();
                } else {
                    compradorModel.setNomeComprador(nomeComprador.getText().toString());
                    compradorModel.setCpfComprador(cpfComprador.getText().toString());

                    // Constroi o bundle com os argumentos a serem passados para a tela de recibo
                    /*
                    bundle.putString("nomeComprador", compradorModel.getNomeComprador());
                    bundle.putString("cpfComprador", compradorModel.getCpfComprador());
                    bundle.putString("tituloRifa", tituloRifa);
                     */
                    bundle.putStringArray("dezenas", data.toArray(new String[data.size()]));

                    Navigation.findNavController(view).navigate(R.id.action_compraFragment_to_reciboFragment, bundle);
                    Toast.makeText(getContext(), "Compra Realizada!", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}