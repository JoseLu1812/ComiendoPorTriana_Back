package com.salesianos.triana.ComiendoPorTriana.doc;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;

@Configuration
public class OpenApiDocsConfig {

    @Bean
    public OpenAPI getOpenAPI(){
        return new OpenAPI()
                .components(new Components())
                .info(new Info()
                        .version("1.0")
                        .contact(new Contact()
                                .name("José Luis Hidalgo Navas")
                                .url("url del repo"))
                        .license(new License().name("MIT License").url("url del license"))
                        .title("ComiendoPorTriana")
                        .description("Comiendo por Triana es una red social de locales de comida en Triana, como bares, restaurantes..."));

    }

}
