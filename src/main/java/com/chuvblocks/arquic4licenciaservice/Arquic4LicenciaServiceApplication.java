package com.chuvblocks.arquic4licenciaservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Arquic4LicenciaServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(Arquic4LicenciaServiceApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
