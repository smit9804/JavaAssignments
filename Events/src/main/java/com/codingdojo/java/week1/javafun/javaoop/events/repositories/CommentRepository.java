package com.codingdojo.java.week1.javafun.javaoop.events.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.java.week1.javafun.javaoop.events.models.Comment;

@Repository
public interface CommentRepository extends CrudRepository<Comment,Long> {

}
