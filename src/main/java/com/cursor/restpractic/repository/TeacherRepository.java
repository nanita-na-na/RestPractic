package com.cursor.restpractic.repository;

import com.cursor.restpractic.model.Teacher;
import org.springframework.data.repository.CrudRepository;

public interface TeacherRepository extends CrudRepository<Teacher, Long> {
}
