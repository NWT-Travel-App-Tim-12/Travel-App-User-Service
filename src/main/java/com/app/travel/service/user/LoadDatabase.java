package com.app.travel.service.user;

import com.app.travel.service.user.model.Role;
import com.app.travel.service.user.model.entity.User;
import com.app.travel.service.user.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(UserRepository repository) {
        repository.save(new User(
                1,
                Role.USER,
                null,
                "amar",
                "begovac",
                "Selima ef Merdanovica",
                "amar@amar.com",
                null,
                "dsasds"
        ));

        return args -> {
            //log.info("Preloading " + repository.save(new User()));
        };
    }
}
