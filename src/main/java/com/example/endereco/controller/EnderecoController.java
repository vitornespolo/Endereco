package com.example.endereco.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

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

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    @Autowired
    EnderecoRepository enderecoRepository;
    @Autowired
    EnderecoServiceImpl enderecoServer;

    @GetMapping
    public List<Endereco> readAll() {

        return enderecoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Endereco>> readOne(@PathVariable Long id) {

        Optional<Endereco> endereco = enderecoRepository.findById(id);
        return endereco != null ? ResponseEntity.ok(endereco) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Endereco> add(@RequestBody Endereco endereco, HttpServletResponse response) {

        Endereco enderecoSalvo = enderecoRepository.save(endereco);
        return ResponseEntity.status(HttpStatus.CREATED).body(enderecoSalvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Endereco> updateEndereco(@RequestBody Endereco newEndereco, @PathVariable Long id) {

        Endereco enderecoSalvo = enderecoServer.atualizar(id, newEndereco);
        return ResponseEntity.ok(enderecoSalvo);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?> delete(@PathVariable Long id) {

        enderecoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}