package com.cursor.restpractic.service.impl;

import com.cursor.restpractic.model.GroupStudents;
import com.cursor.restpractic.repository.GroupStudentsRepository;
import com.cursor.restpractic.service.GroupStudentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GroupStudentsServiceImpl implements GroupStudentsService {

    private final GroupStudentsRepository groupStudentsRepository;

    @Override
    public GroupStudents create(GroupStudents groupStudents) {
        return groupStudentsRepository.save(groupStudents);
    }
}
