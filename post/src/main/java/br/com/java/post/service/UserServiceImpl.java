package br.com.java.post.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.java.post.model.User;
import br.com.java.post.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        Optional<User> user = this.userRepository.findById(id);

        if (user.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return user;
    }

    @Override
    public User create(User userDto) {
        Optional<User> user = this.userRepository.findByUsername(userDto.getUsername());

        if (user.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Already exist this user!");
        }

        return this.userRepository.save(userDto);
    }

    @Override
    public User update(Long id, User userDto) {
        Optional<User> user = this.userRepository.findById(id);

        if (user.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        if (userDto.getIsActive() != null) {
            user.get().setIsActive(userDto.getIsActive());
        }

        if (userDto.getPassword() != null) {
            user.get().setPassword(userDto.getPassword());
        }

        return this.userRepository.save(user.get());
    }

    @Override
    public void remove(Long id) {
        Optional<User> existUser = this.userRepository.findById(id);

        if (existUser.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        this.userRepository.deleteById(id);
    }

}
