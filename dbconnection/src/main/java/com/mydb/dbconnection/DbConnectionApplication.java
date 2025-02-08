package com.mydb.dbconnection;


import java.util.List;
import java.util.Scanner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import 
import org.springframework.context.annotation.Bean;

import com.mydb.dbconnection.component.StudentDAO;
import com.mydb.dbconnection.entity.Student;

@SpringBootApplication 
public class DbConnectionApplication {
	
	private static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		SpringApplication.run(DbConnectionApplication.class, args);
	}

	@Bean
	public CommandLineRunner getHelp(StudentDAO studDAO){ //always should be public 
		return runner -> {
			// System.out.println("hello world");
			// createStudent(studDAO);
			// show(studDAO);
			show(studDAO);
			// show_type1(studDAO);
			// show_type2(studDAO);
			updateDetail(studDAO);

			shows(studDAO);
			sc.close();
		};
	}
	/*private void createStudent(StudentDAO studDao){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the id ");
		int id = sc.nextInt();
		System.out.println("enter the name ");
		String name = sc.nextLine();
		System.out.println("enter the email id ");
		String email = sc.nextLine();
		sc.close();
		Student stud = new Student(id, name, email);
		// studDao.save(stud);
	}*/

	public void updateDetail(StudentDAO studDao){
		
		System.out.println("enter the student id to update the email id ");
		
		int id = sc.nextInt();
		// System.out.println("enter 
		// sc.close();

		studDao.updateDetails(id);

	}

	public void show(StudentDAO studDao){
		System.out.println("enter the student id .. ");
		// Scanner sc = new Scanner(System.in);
		int id = sc.nextInt();
		// sc.close(); //closing the scanner object
		Student temp = studDao.getDetail(id);
		// for(Student temp : l){
		System.out.println(temp.toString());
		// 
	}


	public void shows(StudentDAO studentDAO){
		List<Student> std = studentDAO.getDetails();
		for(Student st : std){
			System.out.println(st.toString());
		}
	}


	public void show_type1(StudentDAO studDao){
		List<Student> student = studDao.type1();
		System.out.println("the student whose email starts with @gmail.com are  ");
		for(Student temp : student){			
			System.out.println(temp.toString());
		}
	}


	//this function returns the studnet having the required name 
	public void show_type2(StudentDAO studentDAO){
		// Scanner sc = new Scanner(System.in);
		System.out.println("enter the student name ");
		String name = sc.nextLine();
		// sc.close();
		List<Student> stud = studentDAO.type2(name);
		for(Student temp : stud ){
			System.out.println(temp.toString());
		}
	}

}
