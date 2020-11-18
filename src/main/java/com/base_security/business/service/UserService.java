package com.base_security.business.service;

import com.base_security.business.model.User;
import com.base_security.business.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void createUsers() {

        User tom = new User("tom", "tom", "ROLE_USER");
        this.userRepository.save(tom);

    }

    public User createOneUser(User user) {
        User createdUser = this.userRepository.save(user);
        return createdUser;
    }

    public User updateUser(String username, User user) {
        User userForUpdate = this.userRepository.findByUsername(username);
        if (userForUpdate != null){
            this.userRepository.delete(userForUpdate);
            user.setId(userForUpdate.getId());
            return this.userRepository.save(user);
        }
        else
            return null;
    }

    public User findUserByUsername(String username) {
        return this.userRepository.findByUsername(username);
    }

}
