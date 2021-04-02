package com.codingdojo.java.week1.javafun.javaoop.greatideas.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.codingdojo.java.week1.javafun.javaoop.greatideas.models.Idea;
import com.codingdojo.java.week1.javafun.javaoop.greatideas.models.User;
import com.codingdojo.java.week1.javafun.javaoop.greatideas.repositories.IdeaRepository;
import com.codingdojo.java.week1.javafun.javaoop.greatideas.repositories.UserRepository;

@Service
public class ProjectService {
    private final UserRepository userRepository;
    private final IdeaRepository ideaRepo;
    
    public ProjectService(UserRepository userRepository, IdeaRepository ideaRepo) {
        this.userRepository = userRepository;
        this.ideaRepo = ideaRepo;
    }
    
    // register user and hash their password
    public User registerUser(User user) {
        String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashed);
        return userRepository.save(user);
    }
    
    // find user by email
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    
    // find user by id
    public User findUserById(Long id) {
    	Optional<User> u = userRepository.findById(id);
    	
    	if(u.isPresent()) {
            return u.get();
    	} else {
    	    return null;
    	}
    }
    
    // authenticate user
    public boolean authenticateUser(String email, String password) {
        // first find the user by email
        User user = userRepository.findByEmail(email);
        // if we can't find it by email, return false
        if(user == null) {
            return false;
        } else {
            // if the passwords match, return true, else, return false
            if(BCrypt.checkpw(password, user.getPassword())) {
                return true;
            } else {
                return false;
            }
        }
    }
    
    // Create Idea
    public Idea createIdea(Idea idea, Long id) {
    	idea.setCreator(findUserById(id));
    	return ideaRepo.save(idea);
    }
    //All ideas
    public List<Idea> findAll(){
    	return ideaRepo.findAll();
    }
    //Find Idea
    public Idea findIdeaById(Long id) {
    	Optional<Idea> idea = ideaRepo.findById(id);
    	if(idea.isPresent()) {
    		return idea.get();
    	}
    	else {
    		return null;
    	}
    }
    //Update Idea
    public Idea updateIdea(Idea idea) {
    	return ideaRepo.save(idea);
    }
    //Delete Idea
    public void deleteIdea(Long id) {
    	ideaRepo.deleteById(id);
    }
}
