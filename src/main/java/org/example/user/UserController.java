package org.example.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@RestController
public class UserController {
    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/users")
    public List<User> userList() {
        return userService.userList();
    }
    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable long id) {
        User user = userService.getUserById(id);
        return user;
    }
    @PostMapping ("/users")
    public ResponseEntity<String> addUser(User user) {
        System.out.println("Chceme zalozit uzivatele " + user.getUsername());
        userService.addUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("User " + user.getUsername() + " zalozen.");
    }
}
