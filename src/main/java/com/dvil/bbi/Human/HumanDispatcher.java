package com.dvil.bbi.Human;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/Human")
public class HumanDispatcher {
    private final HumanService humanService;

    @Autowired
    public HumanDispatcher(HumanService humanService) {
        this.humanService = humanService;
    }


    @GetMapping
    public List<Human> getAllHuman() {
        return humanService.getAllHuman();
    }
}
