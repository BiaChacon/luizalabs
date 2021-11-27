package com.biachacon.apicep.controllers;

import com.biachacon.apicep.dtos.EnderecoDto;
import com.biachacon.apicep.models.Endereco;
import com.biachacon.apicep.services.EnderecoService;
import io.swagger.annotations.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/endereco")
@Api
public class EnderecoController {

    @Autowired
    EnderecoService enderecoService;

    @ApiOperation("Cadastrar um Endereço")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Erro interno do servidor"),
            @ApiResponse(code = 400, message = "Endereço inválido."),
            @ApiResponse(code = 201, message = "Endereço cadastrado.")
    })
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> cadastrarEndereco(
            @ApiParam("Endereço")
            @RequestBody @Valid EnderecoDto enderecoDto) {
        Endereco endereco = new Endereco();
        BeanUtils.copyProperties(enderecoDto, endereco);
        try{
            enderecoService.insert(endereco);
        }catch (Exception E){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(endereco);
    }

    @ApiOperation("Buscar Endereço pelo CEP")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Erro interno do servidor"),
            @ApiResponse(code = 404, message = "Cep inválido")
    })
    @RequestMapping(value = "/{cep}", method = RequestMethod.GET)
    public ResponseEntity<?> buscarEndereco(
            @ApiParam("Exemplo CEP válido: 223339-99")
            @PathVariable String cep) {
        return enderecoService.findEnderecoByCEP(cep);
    }

}
