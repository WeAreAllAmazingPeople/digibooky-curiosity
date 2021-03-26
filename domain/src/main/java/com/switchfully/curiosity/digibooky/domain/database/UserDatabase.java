package com.switchfully.curiosity.digibooky.domain.database;

import com.switchfully.curiosity.digibooky.domain.entities.users.User;

import java.util.UUID;

public interface UserDatabase {
    User createUser(User user);

    User getUserById(UUID userId);
}
