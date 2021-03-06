package com.example.endereco.service;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.endereco.model.Localizacao;

@Service
public class LocalizacaoServiceImpl implements LocalizacaoService {

    private String endInformado;

    public String teste(String test) {

        endInformado = test;

        return endInformado;
    }

    public String endReserva = endInformado == null ? "1600+Amphitheatre+Parkway,+Mountain+View,+CA" : endInformado;
    private final String URI = "https://maps.googleapis.com/maps/api/geocode/json?address=" + endReserva + "&key=AIzaSyCj0cY2yEvVfYhAaTz3-P2MW-YRKmhz5Uw";
    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<Localizacao> responseEntity = restTemplate.exchange(URI, HttpMethod.GET, null,
            Localizacao.class);
    Localizacao jsonString = responseEntity.getBody();
    JSONObject obj = new JSONObject(jsonString);
    JSONArray arr = obj.getJSONArray("results");

    public JSONObject consumerApi() {

        JSONObject jsonString = null;

        for (int i = 0; i < arr.length(); i++) {
            jsonString = arr.getJSONObject(i).getJSONObject("geometry").getJSONObject("location");
        }
        System.out.println("retorno :" + URI);
        return jsonString;
    }

    public double longitude() {

        double lng = 0;
        lng = consumerApi().getDouble("lng");

        return lng;
    }

    public double latitude() {

        double lat = 0;
        lat = consumerApi().getDouble("lat");
        return lat;
    }
}