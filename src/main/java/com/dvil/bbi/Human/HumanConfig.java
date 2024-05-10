package com.dvil.bbi.Human;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.time.Month.*;

@Configuration
public class HumanConfig {

    @Bean
    CommandLineRunner commandLineRunner(HumanRepository repo){
        return args -> {
            Human ahihi = new Human(
                    "Duy",
                    LocalDate.of(2003, MAY, 11),
                    "duy@gmail.com"
            );

            Human ahuhu = new Human(
                    "Not Duy",
                    LocalDate.of(2005, MAY, 11),
                    "notduy@gmail.com"
            );

            repo.saveAll(
                    List.of(ahihi, ahuhu)
            );
        };
    }
}
