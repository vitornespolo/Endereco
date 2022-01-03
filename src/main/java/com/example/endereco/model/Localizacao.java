package com.example.endereco.model;

import javax.persistence.Entity;

import lombok.Data;

@Data
public class Localizacao {

    private double lat;
    private double lng;
}
