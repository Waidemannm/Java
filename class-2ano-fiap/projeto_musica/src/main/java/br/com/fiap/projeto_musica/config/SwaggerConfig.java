package br.com.fiap.projeto_musica.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI configurarSwagger(){
        return new OpenAPI().info(new Info().title("Projeto de Gestão de Músicas, Bandas e Integrantes").description("Este é um projeto que realiza o gerenciamento de músicas, artistas e integrantes com seviços de caching, hypermidia, etc").summary("Projeto para gestão musical").version("1.0.0").termsOfService("Textão").license(new License().url("/licenses").name("Premium license")));
    }
}
