package com.codingdojo.java.week1.javafun.javaoop.dojoninjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.java.week1.javafun.javaoop.dojoninjas.models.Dojo;

public interface DojoRepository extends CrudRepository <Dojo, Long>{
	List<Dojo> findAll();
}
