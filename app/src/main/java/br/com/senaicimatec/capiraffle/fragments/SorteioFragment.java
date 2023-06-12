package br.com.senaicimatec.capiraffle.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import br.com.senaicimatec.capiraffle.R;
import br.com.senaicimatec.capiraffle.api.SorteioService;
import br.com.senaicimatec.capiraffle.models.SorteioModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SorteioFragment extends Fragment {
    private Retrofit retrofit;
    private TextView resultSorteio;
    private  Button sortearBtn;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sorteio, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        retrofit = new Retrofit.Builder()
                .baseUrl("https://www.random.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        resultSorteio = view.findViewById(R.id.retonoApi);
        sortearBtn = view.findViewById(R.id.sortearBtn);

        sortearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recuperaDados();
            }
        });
    }

    public void recuperaDados(){
        SorteioService sorteioService = retrofit.create(SorteioService.class);
        Call<SorteioModel> call = sorteioService.RecuperaDados();

        call.enqueue(new Callback<SorteioModel>() {
            @Override
            public void onResponse(Call<SorteioModel> call, Response<SorteioModel> response) {
                SorteioModel valor = response.body();
                resultSorteio.setText(valor.getValor());

            }

            @Override
            public void onFailure(Call<SorteioModel> call, Throwable t) {

            }
        });
    }
}