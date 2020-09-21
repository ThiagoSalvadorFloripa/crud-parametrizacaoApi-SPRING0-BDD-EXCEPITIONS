package br.salvador.thiago.parametrizacao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
public class ParametrizacaoApplication {

    public static void main(String[] args) {

        SpringApplication.run(ParametrizacaoApplication.class, args);
    }

}
