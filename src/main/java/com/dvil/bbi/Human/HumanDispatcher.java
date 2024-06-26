package com.dvil.bbi.Human;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public void addHuman(@RequestBody Human human){
        humanService.addHuman(human);
    }

    @DeleteMapping(path = "{humanID}")
    public void deleteHuman(@PathVariable("humanID") int humanID){
        humanService.deleteHuman(humanID);
    }

    @PutMapping(path = "{humanID}")
    public void updateHuman(@PathVariable("humanID") int humanID,
                            @RequestParam(required = false) String name,
                            @RequestParam(required = false) String email){
        humanService.updateHuman(humanID, name, email);


    }
}
