package com.codingdojo.java.week1.javafun.javaoop.events.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.java.week1.javafun.javaoop.events.models.Event;

@Repository
public interface EventRepository extends CrudRepository<Event,Long> {
	List<Event> findByStateContains(String state);
	List<Event> findByStateNotContains(String state);

}
