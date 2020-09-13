package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Gender;
import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student addStudent(Student student){
        return studentRepository.addStudent(student);
    }

    public void deleteStudent(int id){
        studentRepository.deleteStudentById(id);
    }

    public List<Student> getStudents() {
        return studentRepository.getStudents();
    }

    public List<Student> getStudentsByGender(Gender gender) {
        return studentRepository.getStudentsByGender(gender);
    }

    public Student getOneStudent(int id) {
        return studentRepository.getOneStudentById(id);
    }
}
