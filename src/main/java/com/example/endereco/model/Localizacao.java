package com.example.endereco.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Localizacao {

    private List<Result> results;
    private Endereco endereco;

    public Endereco getEndereco() {

        if (endereco == null) {
            this.endereco = new Endereco();
        }
        return endereco;
    }

    public void setEndereco(Endereco endereco) {

        this.endereco = endereco;
    }
}
