package com.hronom.coolhub.coolhubuser.controller;

import com.hronom.coolhub.coolhubuser.service.MainService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@Validated
@RequestMapping("/main")
public class MainController {
    private final Logger logger = LoggerFactory.getLogger(MainController.class);

    private final MainService mainService;

    @Autowired
    public MainController(MainService mainService) {
        this.mainService = mainService;
    }

    @PostMapping(path = "/post")
    public String create(UserPojo userPojo) {
        try {
            return mainService.create(userPojo);
        } catch (Exception e) {
            logger.error("Error", e);
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }

    @GetMapping(path = "/post")
    public List<UserPojo> getAll() {
        try {
            return mainService.getAll();
        } catch (Exception e) {
            logger.error("Error", e);
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }
}
