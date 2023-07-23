package br.com.java.post.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.java.post.model.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByUserId(Long userId);
}
