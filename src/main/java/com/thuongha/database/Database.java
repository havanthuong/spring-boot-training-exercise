package com.thuongha.database;

import com.thuongha.models.User;
import com.thuongha.repositories.UserRepository;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.logging.Logger;

@Configuration
public class Database {
//    private static final Logger logger = (Logger) LoggerFactory.getLogger(Database.class);
    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository){
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                User user1 = new User(1,"User A",20,"user.a@gmail.com");
                User user2 = new User(2,"User b",20,"user.b@gmail.com");
                LoggerFactory.getLogger("Insert data " + userRepository.save(user1));
                LoggerFactory.getLogger("Insert data " + userRepository.save(user2));
            }
        };
    }
}
