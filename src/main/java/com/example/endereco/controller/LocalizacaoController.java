package com.example.endereco.controller;

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

    @GetMapping
    public ResponseEntity<String> getLocalizacao() {

        JSONObject localizacao = localizacaoService.consumerApi();
        String teste = localizacao.toString();

        return ResponseEntity.ok(teste);
    }
}
