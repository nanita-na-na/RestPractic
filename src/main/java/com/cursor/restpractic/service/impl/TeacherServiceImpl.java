package com.cursor.restpractic.service.impl;

import com.cursor.restpractic.dto.TeacherDto;
import com.cursor.restpractic.exceptions.TeacherNotFoundException;
import com.cursor.restpractic.model.GroupStudents;
import com.cursor.restpractic.model.Teacher;
import com.cursor.restpractic.repository.GroupStudentsRepository;
import com.cursor.restpractic.repository.TeacherRepository;
import com.cursor.restpractic.service.TeacherService;
import com.cursor.restpractic.service.mapper.TeacherMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;
    private final GroupStudentsRepository groupStudentsRepository;
    private final TeacherMapper teacherMapper;

    @Override
    public TeacherDto create(TeacherDto teacherDto) {
        Teacher teacher = teacherMapper.mapToTeacher(teacherDto);
        Teacher saveTeacher = teacherRepository.save(teacher);
        return teacherMapper.mapToTeacherDto(saveTeacher);
    }


    @Override
    public TeacherDto addTeacherToGroup(Long teacherId, Long groupId) {

        if (!teacherRepository.existsById(teacherId)) {
            throw new TeacherNotFoundException("Teacher no found");
        }
        Teacher teacher = teacherRepository.findById(teacherId).get();

        GroupStudents groupStudents = groupStudentsRepository.findById(groupId).get();
        groupStudents.setTeacher(teacher);
        teacherRepository.save(teacher);
        TeacherDto teacherDto = teacherMapper.mapToTeacherDto(teacher);

        return teacherDto;
    }

    @Override
    public void deleteTeacherFromGroup(Long groupId) {
        GroupStudents groupStudents = groupStudentsRepository.findById(groupId).get();
        groupStudents.setTeacher(null);
        groupStudentsRepository.save(groupStudents);
    }

    @Override
    public List<GroupStudents> getGroupsForTeacher(Long teacherId) {
        if (!teacherRepository.existsById(teacherId)) {
            throw new TeacherNotFoundException("Teacher no found");
        }
        return teacherRepository.findById(teacherId).get().getGroupStudents();

    }
}