package com.devcookhome.services;

import com.devcookhome.model.User;

public interface UserService {
    User save(User user);
    User findByUsername(User username);
}