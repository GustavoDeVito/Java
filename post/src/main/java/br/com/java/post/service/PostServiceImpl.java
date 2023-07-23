package br.com.java.post.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.java.post.helper.MessageHelper;
import br.com.java.post.model.Post;
import br.com.java.post.repository.PostRepository;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepository postRepository;

    @Autowired
    UserService userService;

    @Override
    public List<Post> findAll() {
        return this.postRepository.findAll();
    }

    @Override
    public List<Post> findByUserId(Long userId) {
        this.userService.findById(userId);
        return this.postRepository.findByUserId(userId);
    }

    @Override
    public Post create(Post postDto) {
        this.userService.findById(postDto.getUserId());
        return this.postRepository.save(postDto);
    }

    @Override
    public void remove(Long id) {
        Optional<Post> existPost = this.postRepository.findById(id);

        if (existPost.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, MessageHelper.getPostNotFound());
        }

        this.postRepository.deleteById(id);
    }

}
