package com.cursor.restpractic.service;

import com.cursor.restpractic.dto.TeacherDto;
import com.cursor.restpractic.model.GroupStudents;

import java.util.List;

public interface TeacherService {

    TeacherDto create(TeacherDto teacherDto);

    TeacherDto addTeacherToGroup(Long teacherId, Long groupId);

    void deleteTeacherFromGroup(Long groupId);

    List<GroupStudents> getGroupsForTeacher(Long teacherId);
}
