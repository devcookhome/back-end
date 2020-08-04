package com.devcookhome.dao;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.devcookhome.model.Group;

@Repository
public interface GroupRepository extends CrudRepository<Group, Long> {
}
