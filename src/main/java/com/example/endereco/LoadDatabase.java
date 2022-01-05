package com.example.endereco;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.endereco.model.Endereco;
import com.example.endereco.repository.EnderecoRepository;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(EnderecoRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(
                    new Endereco("Rua bom amparo", 123, null, "pessima", "new city", "PR", "BR", "85515-000",
                            -26.0750377, -52.8413367)));
            log.info("Preloading " + repository.save(
                    new Endereco("the elfeice", 15523, null, "boa", "New York", "NY", "USA", "8585-855", -52.8413367,
                            -74.2598649)));
        };
    }
}