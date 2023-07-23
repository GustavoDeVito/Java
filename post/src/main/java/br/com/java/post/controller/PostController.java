package br.com.java.post.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.java.post.dto.PostCreateDto;
import br.com.java.post.model.Post;
import br.com.java.post.service.PostService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    PostService postService;

    @GetMapping
    List<Post> findAll() {
        return this.postService.findAll();
    }

    @GetMapping("/{userId}")
    List<Post> findPostsByUserId(@PathVariable("id") Long userId) {
        return this.postService.findByUserId(userId);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    Post create(@Valid @RequestBody PostCreateDto postCreatedto) {
        Post post = modelMapper.map(postCreatedto, Post.class);
        return this.postService.create(post);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void remove(@PathVariable("id") Long id) {
        this.postService.remove(id);
    }

}
