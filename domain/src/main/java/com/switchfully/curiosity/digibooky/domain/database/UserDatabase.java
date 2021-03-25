package com.switchfully.curiosity.digibooky.domain.database;

import com.switchfully.curiosity.digibooky.domain.entities.users.User;

public interface UserDatabase {
    User createUser (User user);
}
