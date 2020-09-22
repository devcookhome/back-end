package com.devcookhome.services;

import com.devcookhome.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import com.devcookhome.dao.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
  	private UserRepository repository;	

    public User save(User user){
    	return repository.save(user);
    }
}