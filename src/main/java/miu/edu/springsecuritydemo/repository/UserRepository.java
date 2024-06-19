package miu.edu.springsecuritydemo.repository;

import miu.edu.springsecuritydemo.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    JpaRepository<User, Long> findByEmail(String email);
    Optional<User> findByUsername(String username);
}
