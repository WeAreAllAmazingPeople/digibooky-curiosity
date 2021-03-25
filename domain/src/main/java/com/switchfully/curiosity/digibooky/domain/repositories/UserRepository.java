package com.switchfully.curiosity.digibooky.domain.repositories;

import com.switchfully.curiosity.digibooky.domain.entities.users.User;

public interface UserRepository {

    User createUser(User user);
}
