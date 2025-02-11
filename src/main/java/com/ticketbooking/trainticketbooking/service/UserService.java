package com.ticketbooking.trainticketbooking.service;

import com.ticketbooking.trainticketbooking.entity.User;
import com.ticketbooking.trainticketbooking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     *
     * @param user
     * @return User
     */
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    /**
     *
     * @return List<User></>
     */
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     *
     * @param userId
     */
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
