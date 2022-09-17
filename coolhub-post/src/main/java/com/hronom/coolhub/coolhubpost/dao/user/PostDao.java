package com.hronom.coolhub.coolhubpost.dao.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class PostDao {

    private final HashMap<String, Post> map = new HashMap<>();

    @Autowired
    public PostDao() {
    }

    public String insert(Post post) {
        map.put(post.id(), post);
        return post.id();
    }

    public Post findById(String id) {
        return map.get(id);
    }

    public List<Post> findAll() {
        return new ArrayList<>(map.values());
    }
}
