package lzc.com.example.cruddemo.dao;

import lzc.com.example.cruddemo.entity.Student;

public interface StudentDAO {

    void save(Student theStudent);

    Student findById(Integer id);
}
