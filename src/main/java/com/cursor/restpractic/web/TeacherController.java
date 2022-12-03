package com.cursor.restpractic.web;

import com.cursor.restpractic.dto.TeacherDto;
import com.cursor.restpractic.model.GroupStudents;
import com.cursor.restpractic.service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping(value = "/api/teachers")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;

    @PostMapping(value = "/create")
    public ResponseEntity<TeacherDto> create(@Valid @RequestBody TeacherDto teacherDto) {
        return new ResponseEntity<TeacherDto>(teacherService.create(teacherDto), CREATED);
    }

    @PutMapping(value = "/add/{teacherId}/{groupId}")
    public TeacherDto addTeacherToGroup(@PathVariable Long teacherId, @PathVariable Long groupId) {
        return teacherService.addTeacherToGroup(teacherId, groupId);
    }

    @PutMapping(value = "/delete/{groupId}")
    public void deleteTeacherFromGroup(@PathVariable Long groupId) {
        teacherService.deleteTeacherFromGroup(groupId);
    }

    @GetMapping(value = "/groups/{teacherId}")
    public List<GroupStudents> getGroupsForTeacher(@PathVariable Long teacherId) {
        return teacherService.getGroupsForTeacher(teacherId);
    }

}
