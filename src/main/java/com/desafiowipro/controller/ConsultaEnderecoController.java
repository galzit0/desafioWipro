package com.desafiowipro.controller;

import com.desafiowipro.model.ConsultaEnderecoRequest;
import com.desafiowipro.model.Endereco;
import com.desafiowipro.model.EnderecoResponse;
import com.desafiowipro.service.ViaCepService;
import com.desafiowipro.utils.EnderecoNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/v1")
public class ConsultaEnderecoController {

    @Autowired
    private ViaCepService viaCepService;

    @PostMapping("/consulta-endereco")
    public ResponseEntity<EnderecoResponse> consultaEndereco(@RequestBody ConsultaEnderecoRequest consultaEnderecoRequest) {
        Endereco endereco;
        try {
            endereco = viaCepService.consultarCep(consultaEnderecoRequest.getCep());
        } catch (EnderecoNaoEncontradoException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Endereço não encontrado", e);
        }

        double frete = calcularFrete(endereco.getUf());
        EnderecoResponse enderecoResponse = EnderecoResponse.builder()
                .cep(endereco.getCep())
                .rua(endereco.getLogradouro())
                .complemento(endereco.getComplemento())
                .bairro(endereco.getBairro())
                .cidade(endereco.getLocalidade())
                .estado(endereco.getUf())
                .frete(frete)
                .build();

        return new ResponseEntity<>(enderecoResponse, HttpStatus.OK);
    }


    private double calcularFrete(String uf) {
        switch (uf) {
            case "SP":
            case "RJ":
            case "ES":
            case "MG":
                return 7.85;
            case "DF":
            case "GO":
            case "MS":
            case "MT":
                return 12.50;
            case "AL":
            case "BA":
            case "CE":
            case "MA":
            case "PB":
            case "PE":
            case "PI":
            case "RN":
            case "SE":
                return 15.98;
            case "PR":
            case "RS":
            case "SC":
                return 17.30;
            case "AC":
            case "AM":
            case "AP":
            case "PA":
            case "RO":
            case "RR":
            case "TO":
                return 20.83;
            default:
                return 0;
        }
    }

}