package com.codingdojo.java.week1.javafun.javaoop.loginreg.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.java.week1.javafun.javaoop.loginreg.models.User;
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByEmail(String email);
    Optional<User> findById(Long id);
}
