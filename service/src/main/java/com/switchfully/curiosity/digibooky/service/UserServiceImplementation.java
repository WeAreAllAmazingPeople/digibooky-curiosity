package com.switchfully.curiosity.digibooky.service;

import com.switchfully.curiosity.digibooky.domain.entities.users.User;
import com.switchfully.curiosity.digibooky.domain.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImplementation implements UserService {

    private final UserRepository repository;

    @Autowired
    public UserServiceImplementation(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User createUser(User user) {
        return repository.createUser(user);
    }
}
