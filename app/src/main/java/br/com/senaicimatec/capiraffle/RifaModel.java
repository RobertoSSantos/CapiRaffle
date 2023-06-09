package br.com.senaicimatec.capiraffle;

public class RifaModel {
    private Integer id;
    private String titulo, nomeCriador, premio, dataFinal;

    public RifaModel(Integer id, String titulo, String nomeCriador, String premio, String dataFinal) {
        this.id = id;
        this.titulo = titulo;
        this.nomeCriador = nomeCriador;
        this.premio = premio;
        this.dataFinal = dataFinal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNomeCriador() {
        return nomeCriador;
    }

    public void setNomeCriador(String nomeCriador) {
        this.nomeCriador = nomeCriador;
    }

    public String getPremio() {
        return premio;
    }

    public void setPremio(String premio) {
        this.premio = premio;
    }

    public String getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(String dataFinal) {
        this.dataFinal = dataFinal;
    }
}
