package com.example.SQLiteDemo.controller;

import com.example.SQLiteDemo.Service.StudentService;
import com.example.SQLiteDemo.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import com.example.SQLiteDemo.entity.Student;
import org.springframework.web.client.RestTemplate;

import javax.xml.ws.Response;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/student")
    public List<Student> getAllStudents(){
        return studentService.findAll();
    }

    @PostMapping("/student")
    public String createStudent(@RequestBody Student student){
        return studentService.createStudent(student);
    }

    @GetMapping("/department")
    public List<Department> getDepartment(){
       ResponseEntity<Department[]> response = restTemplate.getForEntity("http://localhost:8100/department",Department[].class);
       response.getBody();
       return Arrays.asList(response.getBody());
    }


}
