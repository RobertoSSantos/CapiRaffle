package br.com.senaicimatec.capiraffle.models;

import java.io.Serializable;

public class CompradorModel implements Serializable {
    private Integer idComprador, idRifa;
    private String nomeComprador, cpfComprador, numselecionados;

    public CompradorModel(){

    }

    public int getIdComprador() {
        return idComprador;
    }

    public void setIdComprador(int idComprador) {
        this.idComprador = idComprador;
    }

    public int getIdRifa() {
        return idRifa;
    }

    public void setIdRifa(int idRifa) {
        this.idRifa = idRifa;
    }

    public String getNomeComprador() {
        return nomeComprador;
    }

    public void setNomeComprador(String nomeComprador) {
        this.nomeComprador = nomeComprador;
    }

    public String getCpfComprador() {
        return cpfComprador;
    }

    public void setCpfComprador(String cpfComprador) {
        this.cpfComprador = cpfComprador;
    }

    public String getNumselecionados() {
        return numselecionados;
    }

    public void setNumselecionados(String numselecionados) {
        this.numselecionados = numselecionados;
    }
}
