package com.thuongha.controllers;

import com.thuongha.entity.User;
import com.thuongha.service.UserService;
import com.thuongha.service.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Data
@AllArgsConstructor
@RestController
@RequestMapping("api/v1/users")
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getUsers(){
        return ResponseEntity.ok(this.userService.getUsers());
    }

    @GetMapping("{userId}")
    public ResponseEntity<User> getUser(@PathVariable("userId") Integer id){
        return ResponseEntity.ok(this.userService.getUser(id));
    }

    @PostMapping
    public ResponseEntity<User> createUser(@Validated @RequestBody UserDto user) {
        return ResponseEntity.ok(this.userService.createUser(user));
    }

    @DeleteMapping("{userId}")
    public ResponseEntity<Void> deleteUse(@PathVariable("userId") Integer userId){
        userService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{userId}")
    public ResponseEntity<User> updateUse(
            @PathVariable("userId") Integer id,
            @RequestBody UserDto request
    ){
        return ResponseEntity.ok(this.userService.updateUser(id, request));
    }

}
