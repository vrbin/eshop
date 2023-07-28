package org.example.user;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {

    private UserJpaRepository userJpaRepository;
    public UserService (UserJpaRepository userRepository) {
        this.userJpaRepository = userRepository;
    }

    public void addUser(User user) {
        String hashedPwd = new BCryptPasswordEncoder().encode(user.getPassword());
        System.out.println("Uzivatel " + user.getUsername() + " ulozen?");
        userJpaRepository.save(user);
        System.out.println("Asi ano...");
    }
    public List<User> userList() {
        return userJpaRepository.findAll();
    }

    public User getUserById(long id) {
        return userJpaRepository.findById(id).orElseThrow(
                () -> new RuntimeException(String.format("User with id %d was not found.", id))
        );
    }

}
