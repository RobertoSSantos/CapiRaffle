package br.com.senaicimatec.capiraffle.modules;

public class DezenasModel {
    private String dezena;
    private Boolean condicao;
    // True -> livre
    // False -> ja foi escolhido

    public DezenasModel(String dezena) {
        this.dezena = dezena;
        this.condicao = true;
    }

    public String getDezena() {
        return dezena;
    }

    public void setDezena(String dezena) {
        this.dezena = dezena;
    }

    public Boolean getCondicao() {
        return condicao;
    }

    public void setCondicao(Boolean condicao) {
        this.condicao = condicao;
    }
}
