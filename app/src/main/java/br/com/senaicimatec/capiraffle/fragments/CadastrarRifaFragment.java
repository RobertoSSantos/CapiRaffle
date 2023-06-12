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
import android.widget.Toast;

import br.com.senaicimatec.capiraffle.R;
import br.com.senaicimatec.capiraffle.dao.RifaDao;
import br.com.senaicimatec.capiraffle.models.RifaModel;

public class CadastrarRifaFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cadastrar_rifa, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RifaModel rifaModel = new RifaModel();
        RifaDao rifaDao = new RifaDao(getContext());
        EditText nomeCriador, cpfCriador, chavePixCriador, tituloRifa, premioRifa, valorRifa, dataFinalRifa;
        Button cadastrarBtn;


        nomeCriador = view.findViewById(R.id.cadastroNomeCriador);
        cpfCriador = view.findViewById(R.id.cadastroCpfCriador);
        chavePixCriador = view.findViewById(R.id.cadastroPixCriador);
        tituloRifa = view.findViewById(R.id.cadastroTituloRifa);
        premioRifa = view.findViewById(R.id.cadastroPremio);
        valorRifa = view.findViewById(R.id.cadastroValorNumero);
        dataFinalRifa = view.findViewById(R.id.cadastroDataTermino);
        cadastrarBtn = view.findViewById(R.id.adicionarRifa);

        EditText[] editTexts = {nomeCriador, cpfCriador, chavePixCriador, tituloRifa, premioRifa, valorRifa, dataFinalRifa};

        cadastrarBtn.setOnClickListener(new View.OnClickListener() {
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

                if(!todosCamposPreenchidos){
                    Toast.makeText(getContext(), "Preencha todos os campos corretamente", Toast.LENGTH_SHORT).show();
                } else {
                    rifaModel.setNomeCriador(nomeCriador.getText().toString());
                    rifaModel.setCpfCriador(cpfCriador.getText().toString());
                    rifaModel.setChavePixCriador(chavePixCriador.getText().toString());
                    rifaModel.setTitulo(tituloRifa.getText().toString());
                    rifaModel.setPremio(premioRifa.getText().toString());
                    rifaModel.setValNum(valorRifa.getText().toString());
                    rifaModel.setDataFinal(dataFinalRifa.getText().toString());

                   long id = rifaDao.inserirRifa(rifaModel);

                    Navigation.findNavController(view).navigate(R.id.action_cadastrarRifaFragment_to_homeFragment);
                    Toast.makeText(getContext(), rifaModel.getTitulo() + " Adicionada com id: " + id, Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}