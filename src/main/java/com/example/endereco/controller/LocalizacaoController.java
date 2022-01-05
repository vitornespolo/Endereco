package com.example.endereco.controller;

import java.net.URISyntaxException;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.endereco.service.LocalizacaoServiceImpl;

@RestController
@RequestMapping("/localizacao")
public class LocalizacaoController {

    @Autowired
    LocalizacaoServiceImpl localizacaoService;

    //JSONObject jsonpObject = new JSONObject(localizacaoService.chamarApi());

    @GetMapping
    public ResponseEntity<String> getLocalizacao() {

        JSONObject localizacao = localizacaoService.consumerApi();
        String teste = localizacao.toString();
//        System.out.println(teste);

        return ResponseEntity.ok(teste);
    }
}
