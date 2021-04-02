package com.codingdojo.java.week1.javafun.javaoop.dojoninjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.java.week1.javafun.javaoop.dojoninjas.models.Ninja;

public interface NinjaRepository extends CrudRepository <Ninja, Long>{
	List<Ninja> findAll();
}
