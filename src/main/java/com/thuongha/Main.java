package com.thuongha;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class Main {
    private final UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
    @GetMapping
    public List<User> getUsers(){
        return this.userRepository.findAll();
    }
    @GetMapping("{userId}")
    public ResponseEntity<User> getUser(@PathVariable("userId") Integer id){
        User user = this.userRepository.findById(id).orElse(null);
        System.out.printf(user.toString());
        if (user == null)
            //return 404 bad request
            return ResponseEntity.notFound().build();
        return new ResponseEntity<User>(
                user,
                HttpStatus.CREATED
        );
    }
    @PostMapping
    public ResponseEntity<User> createUser(@Validated @RequestBody User user) {
        return new ResponseEntity<User>(
                this.userRepository.save(user),
                HttpStatus.CREATED
        );
    }
    @DeleteMapping("{userId}")
    public void deleteUse(@PathVariable("userId") Integer id){
        //find id
        User user = this.userRepository.getById(id);
        if (user == null)
            //return 404 bad request
            return;
        this.userRepository.deleteById(id);
    }
    @PutMapping("{userId}")
    public void updateUse(
            @PathVariable("userId") Integer id,
            @RequestBody User request
        ){
        //find id
        User user = this.userRepository.getById(id);
        if (user == null)
            //return 404 bad request
            return;
        user.setAge(request.getAge());
        user.setEmail(request.getEmail());
        user.setUserName(request.getUserName());
        this.userRepository.save(user);
    }

}
