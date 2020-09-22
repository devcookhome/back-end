package com.devcookhome.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.devcookhome.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
