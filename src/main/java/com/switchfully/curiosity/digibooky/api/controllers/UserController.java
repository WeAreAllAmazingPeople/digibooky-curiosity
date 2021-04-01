package com.switchfully.curiosity.digibooky.api.controllers;

import com.switchfully.curiosity.digibooky.api.dtomappers.UserMapper;
import com.switchfully.curiosity.digibooky.api.dtos.CreateDtoUser;
import com.switchfully.curiosity.digibooky.api.dtos.DtoUser;
import com.switchfully.curiosity.digibooky.domain.entities.users.User;
import com.switchfully.curiosity.digibooky.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);


    @Autowired
    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public DtoUser createUser(@RequestBody CreateDtoUser createDtoUser) {
        LOGGER.info("Starting User Registration");
        //Create user
        User userToRegister = userMapper.changeCreateDtoUserToUser(createDtoUser);

        //Call service to create user
        User createdUser = userService.createUser(userToRegister);
        LOGGER.info("Created user with ID: " + userToRegister.getId());

        //Returns a new user created
        return userMapper.changeUserToDtoUser(createdUser);
    }
}

