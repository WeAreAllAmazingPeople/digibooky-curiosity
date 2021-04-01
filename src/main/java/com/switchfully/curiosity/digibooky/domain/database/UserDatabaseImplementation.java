package com.switchfully.curiosity.digibooky.domain.database;

import com.switchfully.curiosity.digibooky.domain.entities.users.User;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
public class UserDatabaseImplementation implements UserDatabase {

    private final Map<UUID, User> userMap = new HashMap<>();

    @Override
    public User createUser(User user) {
        addUser(user);
        return userMap.get(user.getId());
    }

    @Override
    public User getUserById(UUID userId) {
        return userMap.get(userId);
    }

    private void addUser(User user) {
        if (!isNewUser(user)) {
            throw new IllegalArgumentException("User already exists");
        }
        userMap.put(user.getId(), user);
    }

    boolean isNewUser(User user) {//TODO unique:id, inss, email -> TESTS + VALIDATION (TDD)
        return true;
    }
}