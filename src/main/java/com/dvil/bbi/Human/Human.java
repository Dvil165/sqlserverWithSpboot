package com.dvil.bbi.Human;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Human {
    @Id
    @SequenceGenerator(
            name = "human_seq",
            sequenceName = "human_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "human_seq"
    )

    private int id;
    private String name;
    @Transient
    private int age;
    private LocalDate dob;
    private String email;

    public Human() {
    }

    public Human(int id, String name, LocalDate dob, String email) {
        this.id = id;
        this.name = name;

        this.dob = dob;
        this.email = email;
    }

    public Human(String name, LocalDate dob, String email) {
        this.name = name;

        this.dob = dob;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Human{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", dob=" + dob +
                ", email='" + email + '\'' +
                '}';
    }
}
