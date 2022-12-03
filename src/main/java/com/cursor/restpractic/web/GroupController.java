package com.cursor.restpractic.web;

import com.cursor.restpractic.model.GroupStudents;
import com.cursor.restpractic.service.GroupStudentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/groups")
@RequiredArgsConstructor

public class GroupController {
    private final GroupStudentsService groupStudentsService;

    @PostMapping(value = "/create")
    public GroupStudents create(@RequestBody GroupStudents groupStudents) {
        return groupStudentsService.create(groupStudents);
    }
}
