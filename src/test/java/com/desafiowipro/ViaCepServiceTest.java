package com.desafiowipro;

import com.desafiowipro.model.Endereco;
import com.desafiowipro.service.ViaCepService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ViaCepServiceTest {

    @Mock
    private RestTemplate restTemplate;

    @Test
    public void testConsultarCepRetornaEndereco() {
        String uri = "https://viacep.com.br/ws/01001000/json/";
        Endereco endereco = new Endereco();
        endereco.setCep("01001-000");
        endereco.setLogradouro("Praça da Sé");
        endereco.setComplemento("lado ímpar");
        endereco.setBairro("Sé");
        endereco.setLocalidade("São Paulo");
        endereco.setUf("SP");
        endereco.setIbge("3550308");
        endereco.setGia("1004");
        endereco.setDdd("11");
        endereco.setSiafi("7107");


        Mockito.when(restTemplate.getForObject(Mockito.anyString(), Mockito.any()))
                .thenReturn(endereco);

        ViaCepService viaCepService = new ViaCepService();

        Endereco resultado = viaCepService.consultarCep("01001000");

        assertEquals(endereco, resultado);
    }
}
