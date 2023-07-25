package org.example.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class UserService {
    @Autowired
    private UserJpaRepository userJpaRepository;

    public void addUser(User user) {
        userJpaRepository.save(user);
    }
    public List<User> userList() {
        return userJpaRepository.findAll();
    }
}
