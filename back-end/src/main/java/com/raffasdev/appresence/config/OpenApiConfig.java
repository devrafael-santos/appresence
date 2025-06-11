package com.raffasdev.appresence.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI apiV1OpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API Appresence")
                        .version("1.0")
                        .description("API para o sistema de appresence acadêmica")
                        .contact(new io.swagger.v3.oas.models.info.Contact()
                                .name("Rafael Santos")
                                .email("raafael.cs@gmail.com")
                                .url("https://github.com/devrafael-santos"))
                        .license(new io.swagger.v3.oas.models.info.License()
                                .name("Apache 2.0")
                                .url("http://springdoc.org")));
    }
}
