package com.cursor.restpractic.service.mapper;

import com.cursor.restpractic.dto.TeacherDto;
import com.cursor.restpractic.model.Teacher;
import org.springframework.stereotype.Service;

@Service
public class TeacherMapper {
    public TeacherDto mapToTeacherDto(Teacher teacher) {
        TeacherDto teacherDto = new TeacherDto();
        teacherDto.setId(teacher.getId());
        teacherDto.setName(teacher.getName());
        teacherDto.setLastname(teacher.getLastname());
        return teacherDto;
    }

    public Teacher mapToTeacher(TeacherDto teacherDto) {
        Teacher teacher = new Teacher();
        teacher.setName(teacherDto.getName());
        teacher.setLastname(teacherDto.getLastname());
        teacher.setExperience(teacherDto.getExperience());
        return teacher;
    }
}
