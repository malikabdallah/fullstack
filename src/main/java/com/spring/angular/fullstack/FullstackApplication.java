package com.spring.angular.fullstack;

import com.spring.angular.fullstack.model.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class FullstackApplication {

	public static void main(String[] args) {
		SpringApplication.run(FullstackApplication.class, args);
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

		Student student = (Student) context.getBean("student");
		System.out.println(student.getGrades().notes);
	}



}
