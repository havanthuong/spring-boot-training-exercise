package com.thuongha;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
public class Main {
    private final UserRepository userRepository;
    public Main(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
    @GetMapping("api/v1/users")
    public List<User> getUsers(){
        return this.userRepository.findAll();
    }
    @PostMapping("api/v1/user")
    public ResponseEntity<User> createUser(@Validated @RequestBody User user) {
        return new ResponseEntity<User>(
                userRepository.save(user),
                HttpStatus.CREATED
        );
    }
    @DeleteMapping("api/v1/user/{userId}")
    public void deleteUse(@PathVariable("userId") Integer id){
        //find id
        User user = userRepository.getById(id);
        if (user == null)
            //return 404 bad request
            return;
        userRepository.deleteById(id);
    }
}
