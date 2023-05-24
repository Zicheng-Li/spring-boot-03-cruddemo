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
            createStudent(studentDAO);
        };
	}

	private void createStudent(StudentDAO studentDAO) {
		// create a new student
		System.out.println("Creating a new student");
		Student tempStudent = new Student("Paul", "Smith", "hzdkv@example.com");

		// save the new student
		System.out.println("Saving the new student");
		studentDAO.save(tempStudent);
		//display the id of student
		System.out.println("The id of the new student is " + tempStudent.getId());
	}
}
