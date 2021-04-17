package com.springcrud.demo.Service;

import com.springcrud.demo.Entity.Student;
import com.springcrud.demo.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class StudnetServiceImpl {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}
