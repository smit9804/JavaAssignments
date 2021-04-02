package com.codingdojo.java.week1.javafun.javaoop.greatideas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.java.week1.javafun.javaoop.greatideas.models.Idea;

public interface IdeaRepository extends CrudRepository <Idea, Long>{

		List<Idea> findAll();
}
