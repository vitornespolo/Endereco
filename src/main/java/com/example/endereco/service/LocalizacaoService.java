package com.example.endereco.service;

import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.json.*;
import org.springframework.web.client.RestTemplate;

import com.example.endereco.model.Localizacao;

@Service
public class LocalizacaoService {

    private static String test = "1600+Amphitheatre+Parkway,+Mountain+View,+CA";
    private static final String URI = "https://maps.googleapis.com/maps/api/geocode/json?address=" + test +"&key=AIzaSyCj0cY2yEvVfYhAaTz3-P2MW-YRKmhz5Uw";

    private JSONObject jsonpObject = new JSONObject();

    public Localizacao chamarApi() throws URISyntaxException {

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("user-agent", "Application");
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<Localizacao> responseEntity = restTemplate.exchange(URI, HttpMethod.GET, entity, Localizacao.class);

        Localizacao localizacao = responseEntity.getBody();
        MediaType contentType = responseEntity.getHeaders().getContentType();
        HttpStatus statusCode = responseEntity.getStatusCode();

        //JSONObject jsonObject = jsonpObject.getJSONObject(responseEntity.getBody().toString());
        //System.out.println("retorno :" + localizacao);
        return localizacao;
    }

}
