package com.dvil.bbi.Human;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
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

    public void deleteHuman(int humanID) {
        boolean exists = humanRepository.existsById(humanID);
        if (!exists) {
            throw new IllegalStateException("human does not exist");
        } else {
            humanRepository.deleteById(humanID);
        }
    }

    @Transactional
    public void updateHuman(int humanID, String name, String email) {
        Human human = humanRepository.findById(humanID)
                .orElseThrow(() -> new IllegalStateException("human with" +humanID+ "does not exist"));
        if (name != null && !name.isEmpty() &&
            !Objects.equals(human.getName(), name)){
            human.setName(name);
        }

        if (email != null && !email.isEmpty() &&
        !Objects.equals(human.getEmail(), email)) {
            Optional<Human> humanOptional = humanRepository.findHumanByEmail(email);
            if (humanOptional.isPresent()) {
                throw new IllegalStateException("email already in use");
            }
            human.setEmail(email);
        }
    }
}
