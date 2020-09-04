package com.devcookhome.services;

import java.util.List;
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

    /*public Group delete(Group group){
        return repository.delete(group);*/
    
}