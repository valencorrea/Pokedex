package com.certant.pokedexRefactorValen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.server", "com.server.config"})
//@EnableMongoRepositories ("com.server.repository")
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

}
