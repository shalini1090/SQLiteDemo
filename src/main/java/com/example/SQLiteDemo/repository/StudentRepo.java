package com.example.SQLiteDemo.repository;

import com.example.SQLiteDemo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student,Integer> {

    public boolean existsByEmail(String email);
    public List<Student> findAll();

    @Query("Select max(s.id) from Student s")
    public Integer findMaxId();
}
