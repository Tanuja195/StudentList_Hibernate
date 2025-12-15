package com.cdac;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class StudentDAO 
{
	// Student Data Unsert ke liye 
	
	public void writeStudent(Student s) throws Exception 
	{
	
	       
	 Configuration cfg = new Configuration();
	
     cfg.configure("hibernate.cfg.xml");
     SessionFactory factory = cfg.buildSessionFactory();
		       
     Session session = factory.openSession();               // Step 2

     Transaction tx = session.beginTransaction();

     session.persist(s);		// persist() matalab ye session save karega

     tx.commit();
		    	
		
	}

	// view all student list ke liye 
	
	public List<Student> getAllStudents()
	
	{
		
		
		Configuration cfg = new Configuration();
		
	    cfg.configure("hibernate.cfg.xml");
	    
	     SessionFactory factory = cfg.buildSessionFactory();
			       
	     Session session = factory.openSession();               // Step 2

	     Transaction tx = session.beginTransaction();

	      String q = "from Student";
	      
	      List<Student> list = session.createQuery(q, Student.class).list();

	      session.close();
	      
	      return list;
	     
	}

	// Student ka data uske id ke hisanb se lenge taki bad me usko hi update kare 
	
	public Student getStudentById(int id) {
		
		Configuration cfg = new Configuration();
		
		cfg.configure("hibernate.cfg.xml");

	    SessionFactory factory = cfg.buildSessionFactory();
	    
	    Session session = factory.openSession();

	    Student s = session.find(Student.class, id);
	    System.out.println(" obje s is find "+ s);
	    session.close();
		return s;
		
	}
	
	
	// student data update karane ke lliye 
	public void updateStudent(Student s){
		
		Configuration cfg = new Configuration();
		
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory factory = cfg.buildSessionFactory();
		
		Session session = factory.openSession();
		
		Transaction tx = session.beginTransaction();
		
		session.merge(s);
		
		tx.commit();
		
		session.close();
		
		
		
	}

	// record delete karane ke liye
	public void deleteStudent(int id) {
		
		Configuration cfg = new Configuration();
		
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory factory = cfg.buildSessionFactory();
		
		Session session = factory.openSession();
		
		Transaction tx = session.beginTransaction();
		
		Student s = session.find(Student.class, id);	// pehele object lega
		
		if(s != null) {
			session.remove(s);
		}
		
		tx.commit();
		session.close();
	}



	
         
         
		
}

	
	
	
	
	
	

