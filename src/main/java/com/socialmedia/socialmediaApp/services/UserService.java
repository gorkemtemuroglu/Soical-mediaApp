package com.socialmedia.socialmediaApp.services;

import com.socialmedia.socialmediaApp.entities.User;
import com.socialmedia.socialmediaApp.repos.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User saveOneUser(User newUser) {
        return userRepository.save(newUser);
    }

    public User getOneUserById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    public User updateOneUser(Long userId, User newuser) {
        Optional<User> user = userRepository.findById(userId);
        if(user.isPresent()) {
            User foundUser = user.get();
            foundUser.setUserName(newuser.getUserName());
            foundUser.setPassword(newuser.getPassword());
            return userRepository.save(foundUser);
        }else{
            return  null;
        }
    }

    public void deleteById(Long userId) {
        userRepository.deleteById(userId);
    }
}
