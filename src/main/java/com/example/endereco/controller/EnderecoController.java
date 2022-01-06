package com.example.endereco.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.endereco.model.Endereco;
import com.example.endereco.repository.EnderecoRepository;
import com.example.endereco.service.EnderecoServiceImpl;
import com.example.endereco.service.LocalizacaoService;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    @Autowired
    EnderecoRepository enderecoRepository;
    @Autowired
    EnderecoServiceImpl enderecoServer;
    @Autowired
    LocalizacaoService localizacaoService;

    Endereco enderecoSalvo;


    @GetMapping
    public List<Endereco> readAll() {

        return  enderecoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Endereco>> readOne(@PathVariable Long id) {

        Optional<Endereco> endereco = enderecoRepository.findById(id);
        return endereco != null ? ResponseEntity.ok(endereco) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Endereco> add(@RequestBody Endereco endereco, HttpServletResponse response) {

        enderecoSalvo = enderecoRepository.save(endereco);
        localizacaoService.teste(enderecoSalvo ==  null ? "null" : enderecoSalvo.getName());
        return ResponseEntity.status(HttpStatus.CREATED).body(enderecoSalvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Endereco> updateEndereco(@RequestBody Endereco newEndereco, @PathVariable Long id) {

        enderecoSalvo = enderecoServer.atualizar(id, newEndereco);
        localizacaoService.teste(enderecoSalvo ==  null ? "null" : enderecoSalvo.getName());

        return ResponseEntity.ok(enderecoSalvo);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?> delete(@PathVariable Long id) {

        enderecoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/localizacao")
    public ResponseEntity<String> getLocalizacao() {

        JSONObject localizacao = localizacaoService.consumerApi();
        String teste = localizacao.toString();
        System.out.println(enderecoSalvo ==  null ? "null" : enderecoSalvo.getName());
        return ResponseEntity.ok(teste);
    }
}