package com.example.endereco.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.endereco.model.Localizacao;

//@RestController
@Service
public class LocalizacaoService {

    /*
    Falta a Key da api
     */

    public ResponseEntity<Localizacao> chamarApi() {

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.add("user-agent", "Application");
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<Localizacao> localizacao = restTemplate.exchange(
                "https://maps.googleapis.com/maps/api/geocode/json?address=1600+Amphitheatre+Parkway,+Mountain+View,+CA&key=YOUR_API_KEY",
                HttpMethod.GET, entity, Localizacao.class);


        System.out.println("retorno :" + localizacao);
        return localizacao;
    }
}
