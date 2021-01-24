package com.example.gaswaterusagemonitoring.service;

import com.example.gaswaterusagemonitoring.repository.UserRepository;
import com.example.gaswaterusagemonitoring.util.UserMapper;
import io.tej.SwaggerCodgen.model.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UsersService {

    UserRepository userRepository;

    UserMapper userMapper;

    public void addUserData(User userDto) {
        userRepository.save(userMapper.toUserEntity(userDto));
    }

    public List<User> getUserData(Integer userId) {
        return userMapper.toUserDtoList
                (userRepository.findByUserIdOrderByIdDesc(Long.valueOf(userId)));
    }
}
