package com.dvil.bbi.Human;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class HumanService {
    public List<Human> getAllHuman() {
        return List.of(
                new Human(1, "Duy", 21, LocalDate.of(2024, Month.MAY, 11), "duy@gmail.com")
        );
    }
}
