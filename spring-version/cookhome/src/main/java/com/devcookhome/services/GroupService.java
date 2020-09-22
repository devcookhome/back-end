package com.devcookhome.services;

import com.devcookhome.model.Group;

public interface GroupService {
    Iterable<Group> findAll();

    Group save(Group group);

    Group findById(Long id);

    void delete(Group group);
}