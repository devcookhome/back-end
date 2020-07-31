package com.devcookhome.services;

import java.util.List;
import com.devcookhome.model.Group;
import org.springframework.beans.factory.annotation.Autowired;
import com.devcookhome.model.GroupRepository;
import org.springframework.stereotype.Service;

@Service
public class GroupServiceImpl implements GroupService {
    @Autowired
  	private GroupRepository repository;	

    public List<Group> findAll(){
        return null;
    }
}