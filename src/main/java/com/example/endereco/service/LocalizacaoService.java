package com.example.endereco.service;

import org.json.JSONObject;

public interface LocalizacaoService {

    JSONObject consumerApi();

    double longitude();

    double latitude();

    String teste(String teste);
}
