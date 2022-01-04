package com.example.endereco.controller;

import java.net.URISyntaxException;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.endereco.model.Localizacao;
import com.example.endereco.service.LocalizacaoService;

@RestController
@RequestMapping("/localizacao")
public class LocalizacaoController {

    @Autowired
    LocalizacaoService localizacaoService;

    JSONObject jsonpObject = new JSONObject();

    @GetMapping
    public ResponseEntity<Localizacao> getLocalizacao() throws URISyntaxException {

        Localizacao localizacao = localizacaoService.chamarApi();
//        String teste = localizacao.toString();
//        System.out.println(teste);
        //JSONObject jsonObject = jsonpObject.getJSONObject(String.valueOf(localizacao));

        return ResponseEntity.ok( localizacao);
    }

}
