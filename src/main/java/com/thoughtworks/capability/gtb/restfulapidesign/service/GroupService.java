package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Group;
import com.thoughtworks.capability.gtb.restfulapidesign.repository.GroupRepository;
import com.thoughtworks.capability.gtb.restfulapidesign.repository.StudentRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GroupService {
    final GroupRepository groupRepository;
    final StudentRepository studentRepository;

    public GroupService(GroupRepository groupRepository, StudentRepository studentRepository) {
        this.groupRepository = groupRepository;
        this.studentRepository = studentRepository;
    }

    public List<Group> divideGroup() {
        return groupRepository.divideGroup(studentRepository.getStudents());
    }

    public Group updateGroup(int id, String name) {
        return groupRepository.updateGroup(id,name);
    }

    public List<Group> getGroups() {
        return groupRepository.getGroups();
    }

    public Group getOneGroup(int id) {
        return groupRepository.getOneGroup(id);
    }
}
