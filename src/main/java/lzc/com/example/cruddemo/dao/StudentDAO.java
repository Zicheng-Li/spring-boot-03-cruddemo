package lzc.com.example.cruddemo.dao;

import lzc.com.example.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student theStudent);

    Student findById(Integer id);

    List<Student> findAll();
    
    List<Student> findByLastName(String thelastName);

    void update(Student theStudent);

    void deleteById(Integer id);

    int deleteAll();
}
