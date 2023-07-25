package org.example.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserJpaRepository userJpaRepository;

    public void addUser(User user) {

    }

}
