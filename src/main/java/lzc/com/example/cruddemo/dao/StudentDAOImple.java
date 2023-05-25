package lzc.com.example.cruddemo.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lzc.com.example.cruddemo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Override
    public List<Student> findAll() {
        // create query
        TypedQuery<Student> query = entityManager.createQuery("FROM Student order by lastName desc", Student.class);


        // return query results
        return query.getResultList();
    }

    @Override
    public List<Student> findByLastName(String thelastName) {
        // create query
        TypedQuery<Student> query = entityManager.createQuery("FROM Student where lastName = :lastName order by lastName desc", Student.class);

        // set parameter
        query.setParameter("lastName", thelastName);

        // return query results
        return query.getResultList();
    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        // retrieve the student
        Student theStudent = entityManager.find(Student.class, id);

        // delete the student
        entityManager.remove(theStudent);

    }

    @Override
    @Transactional
    public int deleteAll() {
        int numberOfRows = entityManager.createQuery("DELETE FROM Student").executeUpdate();
        return numberOfRows;
    }
}
