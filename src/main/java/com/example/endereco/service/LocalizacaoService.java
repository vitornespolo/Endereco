package com.example.endereco.service;

import java.net.URISyntaxException;

import org.json.JSONObject;

public interface LocalizacaoService {

    JSONObject consumerApi();

    double longitude();

    double latitude();

}
