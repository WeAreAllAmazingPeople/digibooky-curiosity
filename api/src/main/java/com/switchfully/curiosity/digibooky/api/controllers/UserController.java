package com.switchfully.curiosity.digibooky.api.controllers;

import com.switchfully.curiosity.digibooky.api.dtomappers.UserMapper;
import com.switchfully.curiosity.digibooky.api.dtos.DtoUser;
import com.switchfully.curiosity.digibooky.api.dtos.RegisterDtoUser;
import com.switchfully.curiosity.digibooky.domain.entities.users.User;
import com.switchfully.curiosity.digibooky.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @Autowired
    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE) //TODO Do not forget exception handling
    @ResponseStatus(HttpStatus.CREATED)
    public DtoUser createUser(@RequestBody RegisterDtoUser registerDtoUser) { //TODO Discuss try/catch
        //Create user
        User userToRegister = userMapper.changeRegisterDtoToUser(registerDtoUser);

        //Call service to create user
        User createdUser = userService.createUser(userToRegister);

        //Returns a new user created
        return userMapper.changeUserToDto(createdUser);
    }
}
