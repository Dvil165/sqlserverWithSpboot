package com.dvil.bbi.Human;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HumanRepository extends JpaRepository<Human, Integer> {
    //select * from Human where email = ?
    //@Query("select s from Human s where s.email = ?1")
    Optional<Human> findHumanByEmail(String email);
}
