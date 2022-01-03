package com.example.endereco.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.*;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.endereco.model.Endereco;
import com.example.endereco.repository.EnderecoRepository;
import com.example.endereco.service.EnderecoServiceImpl;

import io.restassured.http.ContentType;

@ExtendWith(SpringExtension.class)
@WebMvcTest
public class EnderecoControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private EnderecoController enderecoController;
    @MockBean
    private EnderecoRepository enderecoRepository;
    @MockBean
    EnderecoServiceImpl enderecoServer;

    @BeforeEach
    public void setup() {

        standaloneSetup(this.enderecoController);
    }

    //Tentativa de teste getById
    @Test
    public void deveRetornarSucesso_QuandoBuscarEndereco() {

        Mockito.when(this.enderecoRepository.findById(1L))
                .thenReturn(Optional.of(
                        new Endereco("Rua bom amparo", 123, null, "pessima", "new city", "PR", "BR", "85515-000",
                                -26.0750377, -52.8413367)));

        given()
                .accept(ContentType.JSON)
                .when()
                .get("/enderecos/{id}", 1L)
                .then().statusCode(HttpStatus.OK.value());
    }
}
