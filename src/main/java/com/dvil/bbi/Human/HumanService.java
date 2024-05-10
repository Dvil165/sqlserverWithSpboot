package com.dvil.bbi.Human;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class HumanService {

    private final HumanRepository humanRepository;

    @Autowired
    public HumanService(HumanRepository humanRepository) {
        this.humanRepository = humanRepository;
    }

    public List<Human> getAllHuman() {
        return humanRepository.findAll();
    }

    public void addHuman(Human human) {
//        System.out.println(human);
        Optional<Human> humanByEmail = humanRepository.findHumanByEmail(human.getEmail());
        if (humanByEmail.isPresent()) {
            throw new IllegalStateException("email already in use");
        }
        humanRepository.save(human);
    }
}
