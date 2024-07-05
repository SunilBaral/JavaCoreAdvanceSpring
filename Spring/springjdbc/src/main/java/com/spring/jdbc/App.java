package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.entities.StudentDao;

public class App 
{
    public static void main( String[] args )
    {	
    	//spring jdbc template
        ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);
        StudentDao studentDao = context.getBean("studentDao",StudentDao.class);
        
//        Student student=new Student();
//        student.setId(67);
//        student.setName("Rati");
//        student.setCity("bhadrak");
//        		
//        int res = studentDao.insert(student);
//        System.out.println("student added "+res);
        
//        Student student=new Student();
//        student.setId(456);
//        student.setName("sneha");
//        student.setCity("bam");
//        
//        int res=studentDao.change(student);
//        System.out.println("student updated "+res);
        
//        Student student=new Student();
//        student.setId(67);
//        int res=studentDao.delete(student);
//        System.out.println("student deleted "+res);
//        
//        Student student = studentDao.getStudent(456);
//        System.out.println(student);
        
        List<Student> students = studentDao.getAllStudents();
        for(Student student:students)
        {
        	System.out.println(student);
        }
    }
}
