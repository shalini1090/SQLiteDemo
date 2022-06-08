package com.example.SQLiteDemo.Service;

import com.example.SQLiteDemo.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.SQLiteDemo.entity.Student;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;

    public String createStudent(Student student){
        try{
            if(!studentRepo.existsByEmail(student.getEmail())){
                studentRepo.save(student);
                return "created succesfully";
            }
            else{
                 return "student exists already";
            }
        }
        catch(Exception e){
             throw e;
        }
    }

    public List<Student> findAll(){
        return studentRepo.findAll();
    }
}
