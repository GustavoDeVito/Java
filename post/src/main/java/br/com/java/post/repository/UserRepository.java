package br.com.java.post.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.java.post.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
