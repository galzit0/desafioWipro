package com.desafiowipro.service;

import com.desafiowipro.model.Endereco;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ViaCepService {

    public Endereco consultarCep(String cep) {
        validarCep(cep);
        String uri = "https://viacep.com.br/ws/" + cep + "/json/";
        RestTemplate restTemplate = new RestTemplate();
        Endereco endereco = restTemplate.getForObject(uri, Endereco.class);
        return endereco;
    }

    private void validarCep(String cep) {
        if (cep == null) {
            throw new IllegalArgumentException("CEP não pode ser nulo");
        }
        cep = cep.replaceAll("\\D", "");
        if (cep.length() != 8) {
            throw new IllegalArgumentException("CEP inválido");
        }
    }
}