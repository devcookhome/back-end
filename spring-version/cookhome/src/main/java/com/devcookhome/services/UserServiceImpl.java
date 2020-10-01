package com.devcookhome.services;

import com.devcookhome.model.LoginDTO;
import com.devcookhome.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import com.devcookhome.dao.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
  @Autowired
  private UserRepository repository;
  @Autowired
  private DigestService digest;

  public User save(User user) {
    user.setPassword(digest.digest(user.getPassword()));
    return repository.save(user);
  }


  @Override
  public User findByUsername(LoginDTO login) {
    List<User> users = repository.findByUsername(login.getUsername());
      if(users.isEmpty()){
        return null;
      }
    
      User user = users.get(0);
      
      String password = digest.digest(login.getPassword());

      if(user.getPassword().equals(password)){
        return user;
      }

      return null;
    
  }
}  