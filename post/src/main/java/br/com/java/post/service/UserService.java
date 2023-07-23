package br.com.java.post.service;

import java.util.List;
import java.util.Optional;

import br.com.java.post.model.User;

public interface UserService {
    List<User> findAll();

    Optional<User> findById(Long id);

    User create(User user);

    User update(Long id, User user);

    void remove(Long id);
}
