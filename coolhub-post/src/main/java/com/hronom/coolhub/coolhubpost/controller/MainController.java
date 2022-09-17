package com.hronom.coolhub.coolhubpost.controller;

import com.hronom.coolhub.coolhubpost.service.MainService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping(path = "/user")
    public String create(PostPojo postPojo) {
        return mainService.create(postPojo);
    }

    @GetMapping(path = "/user")
    public List<PostPojo> getAll() {
        return mainService.getAll();
    }
}
