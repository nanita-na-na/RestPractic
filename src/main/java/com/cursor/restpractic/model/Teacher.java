package com.cursor.restpractic.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Teacher {

    @Id
    @GeneratedValue

    Long id;
    String name;
    String lastname;
    int experience;

    @OneToMany(mappedBy = "teacher")
    @JsonManagedReference
    private List<GroupStudents> groupStudents;
}
