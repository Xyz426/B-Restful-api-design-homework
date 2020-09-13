package com.thoughtworks.capability.gtb.restfulapidesign.controller;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Gender;
import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student student){
        Student SaveStudent = studentService.addStudent(student);

        return ResponseEntity.status(HttpStatus.CREATED).body(SaveStudent);
    }

    @DeleteMapping(path = "{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteStudent(@PathVariable int id){
        studentService.deleteStudent(id);
    }

    @GetMapping
    public ResponseEntity<List<Student>> getStudents(){
        return ResponseEntity.ok(studentService.getStudents());
    }

    @GetMapping(path = "genders/{gender}")
    public ResponseEntity<List<Student>> getStudentsByGender(@PathVariable String gender){
        return ResponseEntity.ok(studentService.getStudentsByGender(gender.equals("male") ? Gender.MALE:Gender.FEMALE));
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<Student> getOneStudent(@PathVariable int id){
        return ResponseEntity.ok(studentService.getOneStudent(id));
    }
}
