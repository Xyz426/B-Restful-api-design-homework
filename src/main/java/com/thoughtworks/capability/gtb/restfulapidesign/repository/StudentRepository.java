package com.thoughtworks.capability.gtb.restfulapidesign.repository;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Gender;
import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentRepository {
    List<Student> studentList = new ArrayList<>();

    {
        studentList.add(Student.builder().id(1).name("张三").gender(Gender.MALE).build());
        studentList.add(Student.builder().id(2).name("李四").gender(Gender.FEMALE).build());
        studentList.add(Student.builder().id(3).name("王五").gender(Gender.MALE).build());
        studentList.add(Student.builder().id(4).name("小冉").gender(Gender.MALE).build());
        studentList.add(Student.builder().id(5).name("小李").gender(Gender.FEMALE).build());
    }

    public Student addStudent(Student student){
        student.setId(studentList.size()+1);
        studentList.add(student);
        return student;
    }

    public void deleteStudentById(int id) {
        studentList.remove(id - 1);
    }

    public List<Student> getStudents() {
        return studentList;
    }

    public List<Student> getStudentsByGender(Gender gender) {
        List<Student> resultStudents = studentList.stream().filter(student -> student.getGender() == gender)
                .collect(Collectors.toList());

        return resultStudents;
    }

    public Student getOneStudentById(int id) {
        return studentList.get(id - 1);
    }
}
