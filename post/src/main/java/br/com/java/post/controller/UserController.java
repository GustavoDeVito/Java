package br.com.java.post.controller;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.java.post.dto.UserCreateDto;
import br.com.java.post.dto.UserUpdateDto;
import br.com.java.post.model.User;
import br.com.java.post.service.UserService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    UserService userService;

    @GetMapping
    List<User> findAll() {
        return this.userService.findAll();
    }

    @GetMapping("/{id}")
    Optional<User> findOne(@PathVariable("id") Long id) {
        return this.userService.findById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    User create(@Valid @RequestBody UserCreateDto userCreateDto) {
        User user = modelMapper.map(userCreateDto, User.class);
        return this.userService.create(user);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    User update(@PathVariable("id") Long id, @Valid @RequestBody UserUpdateDto userUpdateDto) {
        User user = modelMapper.map(userUpdateDto, User.class);
        return this.userService.update(id, user);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void remove(@PathVariable("id") Long id) {
        this.userService.remove(id);
    }
}