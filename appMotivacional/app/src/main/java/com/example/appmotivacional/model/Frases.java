package com.example.appmotivacional.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Frases implements Serializable {

    @SerializedName("conteudo")
    private String conteudo;
    @SerializedName("autor")
    private String autor;

    public String getConteudo() {
        return conteudo;
    }

    public String getAutor() {
        return autor;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return getConteudo()+"\nAutor:"+getAutor();
    }
}
