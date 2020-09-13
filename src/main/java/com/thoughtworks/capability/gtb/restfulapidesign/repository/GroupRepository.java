package com.thoughtworks.capability.gtb.restfulapidesign.repository;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Group;
import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class GroupRepository {
    List<Group> groupList = new ArrayList<>(6);

    {
        groupList.add(Group.builder().id(1).name("Team1").studentList(new ArrayList<>()).build());
        groupList.add(Group.builder().id(2).name("Team2").studentList(new ArrayList<>()).build());
        groupList.add(Group.builder().id(3).name("Team3").studentList(new ArrayList<>()).build());
        groupList.add(Group.builder().id(4).name("Team4").studentList(new ArrayList<>()).build());
        groupList.add(Group.builder().id(5).name("Team5").studentList(new ArrayList<>()).build());
        groupList.add(Group.builder().id(6).name("Team6").studentList(new ArrayList<>()).build());
    }

    public List<Group> divideGroup(List<Student> studentList) {
        Collections.shuffle(studentList);
        for (int i = 0 ; i < studentList.size(); i++) {
            groupList.get(i % 6).getStudentList().add(studentList.get(i));
        }
        return groupList;
    }

    public Group updateGroup(int id, String name) {
        groupList.get(id - 1).setName(name);

        return groupList.get(id - 1);
    }
}
