package com.biachacon.apicep.controllers;

import static org.mockito.Mockito.*;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.*;
import com.biachacon.apicep.mocks.MockEndereco;
import com.biachacon.apicep.services.EnderecoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import io.restassured.http.ContentType;
import org.springframework.http.ResponseEntity;

@WebMvcTest
class EnderecoControllerTests {

    @Autowired
    private EnderecoController enderecoController;

    @MockBean
    private EnderecoService enderecoService;

    @BeforeEach
    public void setup() {
        standaloneSetup(this.enderecoController);
    }

    @Test
    @DisplayName("Deve retornar o status OK quando buscar endereço com CEP válido.")
    void buscarEnderecoComCepValido() {
        String cep = "12345-678";
        ResponseEntity response = ResponseEntity.ok(MockEndereco.endereco1());
        when(enderecoService.findEnderecoByCEP(cep)).thenReturn(response);
        given().accept(ContentType.JSON).when().get("/endereco/"+cep).then().statusCode(HttpStatus.OK.value());
    }

    @Test
    @DisplayName("Deve retornar o status de erro da requisição quando buscar endereço com CEP inválido.")
    void buscarEnderecoComCepInvalido() {
        String cep = "12345";
        ResponseEntity response = ResponseEntity.badRequest().build();
        when(enderecoService.findEnderecoByCEP(cep)).thenReturn(response);
        given().accept(ContentType.JSON).when().get("/endereco/"+cep).then().statusCode(HttpStatus.BAD_REQUEST.value());
    }

}

