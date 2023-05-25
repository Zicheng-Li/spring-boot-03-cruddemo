package lzc.com.example.cruddemo;

import lzc.com.example.cruddemo.dao.StudentDAO;
import lzc.com.example.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
//            createStudent(studentDAO);

//			createMultipleStudent(studentDAO);

			readStudent(studentDAO);
        };
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
