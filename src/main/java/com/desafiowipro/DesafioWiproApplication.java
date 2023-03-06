package com.desafiowipro;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "Consulta Endereço via CEP",
                version = "1.0.0",
                description = "API REST de consulta de endereço e cáculo de frete para determinado CEP. " +
                        "O valor do frete é fixo de acordo com as regiões do Brasil: Sudeste (R$ 7,85), " +
                        "Centro-Oeste (R$ 12,50), Nordeste (R$ 15,98), Sul (R$ 17,30) e Norte (R$ 20,83). " +
                        "O CEP é obrigatório e pode ser passado com ou sem máscara " +
                        "na entrada e se o CEP não for encontrado uma mensagem informativa deve ser retornada " +
                        "para o cliente.",
                contact = @Contact(
                        name = "Gabriel Pequeno",
                        email = "gabriel.icaroandrade@gmail.com"
                )
        )
)
public class DesafioWiproApplication {

    public static void main(String[] args) {
        SpringApplication.run(DesafioWiproApplication.class, args);
    }
}
