package br.com.java.post.service;

import java.util.List;

import br.com.java.post.model.Post;

public interface PostService {
    List<Post> findAll();

    List<Post> findByUserId(Long userId);

    Post create(Post post);

    void remove(Long id);
}
