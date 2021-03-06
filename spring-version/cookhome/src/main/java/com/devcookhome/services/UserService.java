package com.devcookhome.services;

import java.util.List;

import com.devcookhome.model.User;
import com.devcookhome.model.LoginDTO;


public interface UserService {
    User save(User user);
    User findByUsername(LoginDTO login);
}