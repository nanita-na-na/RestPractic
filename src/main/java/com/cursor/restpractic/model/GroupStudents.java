package com.cursor.restpractic.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class GroupStudents {

    @Id
    @GeneratedValue

    Long id;
    String name;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JsonBackReference
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;
}
