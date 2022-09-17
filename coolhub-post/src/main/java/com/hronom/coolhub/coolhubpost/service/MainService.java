package com.hronom.coolhub.coolhubpost.service;

import com.hronom.coolhub.coolhubpost.controller.PostPojo;
import com.hronom.coolhub.coolhubpost.dao.user.Post;
import com.hronom.coolhub.coolhubpost.dao.user.PostDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MainService {
    private final PostDao postDao;

    @Autowired
    public MainService(PostDao postDao) {
        this.postDao = postDao;
    }

    public List<PostPojo> getAll() {
        List<Post> list = postDao.findAll();
        return list
                .stream()
                .map(this::toPostPojo)
                .toList();
    }

    public String create(PostPojo postPojo) {
        return postDao.insert(toUser(postPojo));
    }

    private Post toUser(PostPojo postPojo) {
        return new Post(
                UUID.randomUUID().toString(),
                postPojo.username(),
                postPojo.firstName(),
                postPojo.lastName()
        );
    }

    private PostPojo toPostPojo(Post post) {
        return new PostPojo(
                post.id(),
                post.owner(),
                post.title(),
                post.text()
        );
    }
}
