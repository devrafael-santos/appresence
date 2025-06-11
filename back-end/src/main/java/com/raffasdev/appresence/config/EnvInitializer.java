package com.raffasdev.appresence.config;

import io.github.cdimascio.dotenv.Dotenv;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

public class EnvInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    @Override
    public void initialize(@NotNull ConfigurableApplicationContext ctx) {
        Dotenv baseEnv = Dotenv.configure()
                .filename(".env")
                .ignoreIfMissing()
                .load();

        Dotenv env = Dotenv.configure()
                .filename(".env." + baseEnv.get("ENVIRONMENT", "dev") + ".local")
                .ignoreIfMissing()
                .load();

        env.entries().forEach(entry -> {
            if (System.getProperty(entry.getKey()) == null) {
                System.setProperty(entry.getKey(), entry.getValue());
            }
        });

        baseEnv.entries().forEach(entry -> {
            if (System.getProperty(entry.getKey()) == null) {
                System.setProperty(entry.getKey(), entry.getValue());
            }
        });
    }
}
