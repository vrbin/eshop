package org.example.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/users")
    public UserService userList() {
        return userService;
    }
    @PostMapping ("/users")
    public ResponseEntity<String> addUser(User user) {
        System.out.println("Chceme zalozit uzivatele " + user.getUsername());
        var encoder = new BCryptPasswordEncoder();
        String encodedPwd = encoder.encode(user.getPassword());
        System.out.println("Hashnute heslo je " + encodedPwd);
        user.setPassword(encodedPwd);
        userService.addUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("User " + user.getUsername() + " zalozen.");
    }
}
