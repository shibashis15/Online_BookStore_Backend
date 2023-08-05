package com.User_Service.com.repository;

import com.User_Service.com.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User getById(Long id);

    Optional<User> findByEmail(String email);

    List<User> findAll();
}
