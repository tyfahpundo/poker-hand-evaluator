package com.tyfah.pockerhandevaluator.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        OpenAPI openApi = new OpenAPI()
                .info(getInfo());

        return openApi;
    }
    private Info getInfo() {
        return new Info()
                .title("Poker-Hand APIs ")
                .version("1.0.0")
                .license(getLicense());
    }
    private License getLicense() {
        return new License()
                .name("Tafadzwa Pundo")
                .url("https://www.github.com/tyfahpundo");
    }

}
