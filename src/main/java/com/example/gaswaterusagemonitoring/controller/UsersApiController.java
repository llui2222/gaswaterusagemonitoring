package com.example.gaswaterusagemonitoring.controller;


import com.example.gaswaterusagemonitoring.service.UsersService;
import io.tej.SwaggerCodgen.api.V1Api;
import io.tej.SwaggerCodgen.model.User;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class UsersApiController implements V1Api {

    UsersService usersService;

    public ResponseEntity<Void> addUserData(User user) {
        usersService.addUserData(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    public ResponseEntity<List<User>> exposeUserConsumptionByUserId(Integer userId) {
        return ResponseEntity.ok(usersService.getUserData(userId));

    }

}
