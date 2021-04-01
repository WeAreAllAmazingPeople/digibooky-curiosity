package com.switchfully.curiosity.digibooky.domain.repositories;

import com.switchfully.curiosity.digibooky.domain.database.UserDatabase;
import com.switchfully.curiosity.digibooky.domain.entities.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UserRepositoryImplementation implements UserRepository {

    private final UserDatabase database;

    @Autowired
    public UserRepositoryImplementation(UserDatabase database) {
        this.database = database;
    }

    @Override
    public User createUser(User user) {
        return database.createUser(user);
    }

    @Override
    public User getUserById(UUID userId) {
        return database.getUserById(userId);
    }
}
