package com.thuongha.service;

import com.thuongha.entity.User;
import com.thuongha.service.dto.UserDto;
import org.springframework.stereotype.Component;

import java.util.List;

public interface UserService{

    List<User> getUsers();

    User getUser(Integer userId);

    User createUser(UserDto request);

    void deleteUser(Integer userId);

    User updateUser(Integer userId, UserDto request);
}
