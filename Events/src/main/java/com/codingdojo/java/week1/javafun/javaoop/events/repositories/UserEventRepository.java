package com.codingdojo.java.week1.javafun.javaoop.events.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.java.week1.javafun.javaoop.events.models.Event;
import com.codingdojo.java.week1.javafun.javaoop.events.models.User;
import com.codingdojo.java.week1.javafun.javaoop.events.models.UserEvent;

@Repository
public interface UserEventRepository extends CrudRepository<UserEvent,Long> {
	List<UserEvent> findByEventContains(Event event);
	UserEvent findByEventAndUser(Event event, User user);
	
}
