package com.devcookhome.services;

import com.devcookhome.model.Group;
import org.springframework.beans.factory.annotation.Autowired;
import com.devcookhome.dao.GroupRepository;
import org.springframework.stereotype.Service;

@Service
public class GroupServiceImpl implements GroupService {
    @Autowired
  	private GroupRepository repository;	

    public Iterable<Group> findAll(){
        return repository.findAll();
    }

    public Group save(Group group){
    	return repository.save(group);
    }

    public Group findById(Long id){
    	return repository.findById(id).get();
    }

    public void delete(Group group){
      repository.delete(group);
    }
}