package br.com.senaicimatec.capiraffle.api;

import br.com.senaicimatec.capiraffle.models.SorteioModel;
import retrofit2.Call;
import retrofit2.http.GET;

public interface SorteioService {
    @GET("integers/?num=1&min=1&max=50&col=1&base=10&format=plain")
    Call<SorteioModel> RecuperaDados();
}
