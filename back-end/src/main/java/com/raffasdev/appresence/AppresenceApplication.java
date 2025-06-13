package com.raffasdev.appresence;

import com.raffasdev.appresence.config.EnvInitializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppresenceApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(AppresenceApplication.class);
        app.addInitializers(new EnvInitializer());
        app.run(args);
    }

}
