package com.example.springrestapi.controller;

import com.example.springrestapi.entity.Student;
import com.example.springrestapi.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    //get all students


    @Autowired
    StudentRepository repo;
    @GetMapping("/students")
    public List<Student> getAllStudents(){
        List<Student>  students =  repo.findAll();
        return students;
    }
    //localhost:8080/students/1
    @GetMapping("/students/{id}")
    public Student getStudents(@PathVariable int id)
    {
       Student student =  repo.findById(id).get();

        return student;
    }
    //localhost:8080/students/add
    @PostMapping("/student/add")
     @ResponseStatus(code = HttpStatus.CREATED)
    public void createStudent(@RequestBody Student student)
    {
       repo.save(student);
    }


    @PutMapping("/student/update/{id}")
    public Student updateStudent(@PathVariable int id)
    {
       Student student =  repo.findById(id).get();
        student.setName("jimi");
        student.setPercentage(36);
       repo.save(student);
       return student;
    }
    @DeleteMapping("/student/delete/{id}")
    public Student deleteStudent(@PathVariable int id)
    {
        Student student =  repo.findById(id).get();
        repo.delete(student);
        return student;
    }

}
