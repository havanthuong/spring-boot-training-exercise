package com.thuongha.service.impl;

import com.thuongha.entity.User;
import com.thuongha.exception.ResourceNotFoundException;
import com.thuongha.repositories.UserRepository;
import com.thuongha.service.UserService;
import com.thuongha.service.dto.UserDto;
import com.thuongha.service.mapper.UserMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    @Override
    public User getUser(Integer userId){
        return this.userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        String.format("Applicant %s not found", userId)
                ));
    }

    @Override
    @Transactional
    public User createUser(UserDto request){
        final User enity = userMapper.toEntity(request);
        log.info("User: {}", enity);
        return this.userRepository.save(enity);
    }

    @Override
    @Transactional
    public User updateUser(Integer userId, UserDto request){
        User user = getUser(userId);
        User userUpdate = userMapper.toEntity(request);
        user.setAge(userUpdate.getAge());
        user.setEmail(userUpdate.getEmail());
        user.setUserName(userUpdate.getUserName());
        return user;
    }

    @Override
    @Transactional
    public void deleteUser(Integer userId){
        User user = getUser(userId);
        userRepository.delete(user);
    }
}
