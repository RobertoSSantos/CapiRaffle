package br.com.senaicimatec.capiraffle.api;

import com.google.gson.JsonObject;

import br.com.senaicimatec.capiraffle.models.SorteioModel;
import retrofit2.Call;
import retrofit2.http.GET;

public interface SorteioService {
    @GET("?5d10.json")
    Call<SorteioModel> recuperaDados();
}
