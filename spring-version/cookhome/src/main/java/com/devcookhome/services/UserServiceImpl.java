package com.devcookhome.services;

import com.devcookhome.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import com.devcookhome.dao.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository repository;
    @Autowired	
    private DigestService digest;

    public User save(User user){
      user.setPassword(digest.digest(user.getPassword()));
      return repository.save(user);
    }
    public User findByUsername(User username){
    	return (User) repository.findByUsername(username);
    }

}