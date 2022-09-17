package com.hronom.coolhub.coolhubuser.service;

import com.hronom.coolhub.coolhubuser.controller.UserPojo;
import com.hronom.coolhub.coolhubuser.dao.user.User;
import com.hronom.coolhub.coolhubuser.dao.user.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MainService {
    private final UserDao userDao;

    private final ErrorGeneratingService errorGeneratingService;

    @Autowired
    public MainService(
            UserDao userDao,
            ErrorGeneratingService errorGeneratingService) {
        this.userDao = userDao;
        this.errorGeneratingService = errorGeneratingService;
    }

    public List<UserPojo> getAll() throws Exception {
        errorGeneratingService.triggerSimpleError();
        List<User> list = userDao.findAll();
        return list
                .stream()
                .map(this::toUserPojo)
                .toList();
    }

    public String create(UserPojo userPojo) throws Exception {
        errorGeneratingService.triggerSimpleError();
        return userDao.insert(toUser(userPojo));
    }

    private User toUser(UserPojo userPojo) {
        return new User(
                UUID.randomUUID().toString(),
                userPojo.username(),
                userPojo.firstName(),
                userPojo.lastName()
        );
    }

    private UserPojo toUserPojo(User user) {
        return new UserPojo(
                user.id(),
                user.username(),
                user.firstName(),
                user.lastName()
        );
    }
}
