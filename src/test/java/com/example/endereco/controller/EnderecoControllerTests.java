package com.example.endereco.controller;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.standaloneSetup;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.endereco.model.Endereco;
import com.example.endereco.repository.EnderecoRepository;
import com.example.endereco.service.EnderecoServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
//@RunWith(SpringRunner.class)
//@WebMvcTest(EnderecoController.class)
public class EnderecoControllerTests {

    @Autowired
    private MockMvc mvc;
    @Autowired
    private ObjectMapper objectMapper;
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

    @Test
    public void enderecoGetAll() throws Exception {

        mvc.perform(MockMvcRequestBuilders.get("/enderecos"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void enderecoGetId() throws Exception {

        mvc.perform(MockMvcRequestBuilders.get("/enderecos/{id}", 1))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void enderecoSave() throws Exception {

        Endereco endereco = new Endereco("Rua numero quatro", 123, null, "pessima", "new city", "PR", "BR", "85515-000",
                -26.0750377, -52.8413367);

        mvc.perform(MockMvcRequestBuilders.post("/enderecos")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(endereco)))
                .andExpect(MockMvcResultMatchers.status().isCreated());

    }

    @Test
    public void enderecoUpdate() throws Exception {

        Endereco endereco = new Endereco("Rua numero quatro", 123, null, "pessima", "new city", "PR", "BR", "85515-000",
                -26.0750377, -52.8413367);

        mvc.perform(MockMvcRequestBuilders.put("/enderecos/{id}", 2)
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(endereco)))
                .andExpect(MockMvcResultMatchers.status().isOk())
        ;
    }

    @Test
    public void deleteEndereco() throws Exception {

        mvc.perform(MockMvcRequestBuilders.delete("/enderecos/{id}", 1))
                .andExpect(MockMvcResultMatchers.status().isNoContent());
    }
}
