package com.codingdojo.java.week1.javafun.javaoop.productcategory.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.java.week1.javafun.javaoop.productcategory.models.Product;

@Repository
public interface PRepo extends CrudRepository<Product, Long>{
	List<Product> findAll();
}
