package com.devcookhome.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.devcookhome.model.Group;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {

  List<Group> findAll();

  Group findById(long id);
}
