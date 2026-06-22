package com.example.ecommerce.services;

import com.example.ecommerce.entities.User;
import com.example.ecommerce.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User registerUser(User user){
        return userRepository.save(user);
    }

    public User getUserById(Long id){
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Fetch Error: User not found"));
    }

    public User getUserByEmail(String email){
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Fetch Error: User not found"));
    }

    public User updateUser(Long id, User user){
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Update Error: User not found"));

        existingUser.setEmail(existingUser.getEmail());
        existingUser.setFirstName(existingUser.getFirstName());
        existingUser.setLastName(existingUser.getLastName());
        existingUser.setPassword(existingUser.getPassword());

        return userRepository.save(existingUser);

    }

    public void deleteUser(Long id){
        User user = userRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Delete Error: User not found"));

        userRepository.deleteById(id);
    }


}


