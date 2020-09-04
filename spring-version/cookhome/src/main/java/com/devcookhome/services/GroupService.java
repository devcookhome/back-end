package com.devcookhome.services;

import java.util.List;
import com.devcookhome.model.Group;

public interface GroupService {
    Iterable<Group> findAll();

    Group save(Group group);

    Group findById(Long id);

    /*Group delete(Group group);*/
}