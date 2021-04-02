package com.codingdojo.java.week1.javafun.javaoop.productcategory.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.java.week1.javafun.javaoop.productcategory.models.Category;

@Repository
public interface CRepo extends CrudRepository<Category, Long> {
	List<Category> findAll();


}