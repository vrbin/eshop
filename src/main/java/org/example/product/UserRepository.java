package org.example.product;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
public interface UserRepository extends JpaRepository<User, String> {
    User findByUsername(String username);
    Boolean existsByUsername(String username);
}
