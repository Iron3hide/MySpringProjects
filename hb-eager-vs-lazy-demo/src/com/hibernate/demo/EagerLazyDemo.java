package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Course;
import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;
import com.hibernate.demo.entity.Student;

public class EagerLazyDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			
			//start a transaction
			session.beginTransaction();
			
			// get the instructor from db
			int theId = 1;
			Instructor tempInstructor = session.get(Instructor.class, theId);
			
			System.out.println("LUV2CODE: Instructor: " + tempInstructor);
			
			System.out.println("LUV2CODE: Courses: " + tempInstructor.getCourses());
			
			//commit transaction
			session.getTransaction().commit();
			
			//close the session
			session.close();
			
			System.out.println("\n LUV2CODE: The session is now closed!\n");
			
			// option 1: call getter method while session is open
			
			//get course for the instructor
			System.out.println("LUV2CODE: Courses: " + tempInstructor.getCourses());
			
			
			System.out.println("LUV2CODE: Done!");
		}
		
		finally {
			// add clean up code
			session.close();
			
			factory.close();
		}
	}
}
