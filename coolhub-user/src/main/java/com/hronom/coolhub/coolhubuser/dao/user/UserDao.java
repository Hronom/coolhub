package com.hronom.coolhub.coolhubuser.dao.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class UserDao {

    private final HashMap<String, User> map = new HashMap<>();

    @Autowired
    public UserDao() {
    }

    public String insert(User user) {
        map.put(user.id(), user);
        return user.id();
    }

    public User findById(String id) {
        return map.get(id);
    }

    public List<User> findAll() {
        return new ArrayList<>(map.values());
    }
}
