package lzc.com.example.cruddemo;

import lzc.com.example.cruddemo.dao.StudentDAO;
import lzc.com.example.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
//            createStudent(studentDAO);

			createMultipleStudent(studentDAO);

//			readStudent(studentDAO);

//			queryStudent(studentDAO);

//			queryStudentByLastname(studentDAO);

//			updateStudent(studentDAO);

//			deleteStudent(studentDAO);

//			deleteAllStudent(studentDAO);
        };
	}

	private void deleteAllStudent(StudentDAO studentDAO) {
		System.out.println("Deleting all students");
		int count=studentDAO.deleteAll();
		System.out.println("Deleted "+count+" rows students");
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int id=3;
		System.out.println("Deleting student with id: " + id);
		studentDAO.deleteById(id);
	}

	private void updateStudent(StudentDAO studentDAO) {
		// retrieve student id
		int id=1;
		System.out.println("Retrieving student with id: " + id);
		Student student = studentDAO.findById(id);

		//change the first name to "Scooby"
		student.setFirstName("Scooby");
        System.out.println("Updating student with id: " + id);

		// update the student
		studentDAO.update(student);

		// display the updated student
		System.out.println("Updated student: " + student);
	}

	private void queryStudentByLastname(StudentDAO studentDAO) {
		// get a list of all students
		List<Student> students = studentDAO.findByLastName("jin");

		//display all students
		for (Student student : students) {
            System.out.println(student);
        }
	}

	private void queryStudent(StudentDAO studentDAO) {
		// get a list of all students
		List<Student> students = studentDAO.findAll();

		// display all students
        for (Student student : students) {
            System.out.println(student);
        }
	}

	private void readStudent(StudentDAO studentDAO) {
		// create a student

		// create  a student object
		System.out.println("Creating new student object ...");
		Student tempStudent = new Student("Daffy", "Duck", "daffy@luv2code.com");

		// save the student
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);

		// display id of the saved student
		int theId = tempStudent.getId();
		System.out.println("Saved student. Generated id: " + theId);

		// retrieve student based on the id: primary key
		System.out.println("Retrieving student with id: " + theId);
		Student myStudent = studentDAO.findById(theId);

		// display student
		System.out.println("Found the student: " + myStudent);
	}

	private void createMultipleStudent(StudentDAO studentDAO) {
		// create multiple students
		System.out.println("Creating 3 new student");
		Student tempStudent1 = new Student("john", "man", "jman@example.com");
		Student tempStudent2 = new Student("qu", "jin", "jqu@example.com");
		Student tempStudent3 = new Student("fazzer", "kazeen", "kfazz@example.com");

		//save the new student
		System.out.println("Saving the 3 student");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

	}

	private void createStudent(StudentDAO studentDAO) {
		// create a new student
		System.out.println("Creating a new student");
		Student tempStudent = new Student("Paul", "Smith", "paul@example.com");

		// save the new student
		System.out.println("Saving the new student");
		studentDAO.save(tempStudent);
		//display the id of student
		System.out.println("The id of the new student is " + tempStudent.getId());
	}
}
