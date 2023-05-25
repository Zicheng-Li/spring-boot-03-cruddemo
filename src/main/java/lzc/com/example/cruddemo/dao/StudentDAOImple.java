package lzc.com.example.cruddemo.dao;

import jakarta.persistence.EntityManager;
import lzc.com.example.cruddemo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class StudentDAOImple implements StudentDAO {

    // Define entity manager
    private EntityManager entityManager;

    // inject entity manager
    @Autowired
    public StudentDAOImple(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }
}
