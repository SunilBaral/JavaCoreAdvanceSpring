package com.jpa.test;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.jpa.test.dao.UserRepository;
import com.jpa.test.entities.User;

@SpringBootApplication
public class BootjpaexampleApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(BootjpaexampleApplication.class, args);
		UserRepository userRepository = context.getBean(UserRepository.class);
		
//		User user=new User();
//		user.setName("Sunil");
//		user.setCity("bbsr");
//		user.setStatus("i am a java programmer");

		//for single user insert
//		User user1 = userRepository.save(user);
//		
//		System.out.println(user1);
		
//		User user1=new User();
//		user1.setName("Dillip");
//		user1.setCity("jajpur");
//		user1.setStatus("govt employee");
//		
//		User user2=new User();
//		user2.setName("Harapriya");
//		user2.setCity("keunjhar");
//		user2.setStatus("Central govt employee");
//		
//		
//		//saving multiple user
//		
//		List<User> users = List.of(user1,user2);
//		Iterable<User> result = userRepository.saveAll(users);
//		
//		result.forEach(user->{
//			System.out.println(user);
//		});
		
		
		// update the user of id 1
//			 Optional<User> optional = userRepository.findById(1);
//			User user = optional.get();
//			user.setName("Sunil Baral");
//			User result = userRepository.save(user);
//			System.out.println(result);
		
		
		//how to get data
		//Iterable<User> itr = userRepository.findAll();
//		Iterator<User> iterator = itr.iterator();
//		
//		while(iterator.hasNext())
//		{
//			User user=iterator.next();
//			System.out.println(user);
//		}
		
		//itr.forEach(user ->{System.out.println(user);} );
			//delete by id
//			userRepository.deleteById(2);
//			
//			//deleteall
//			Iterable<User> all = userRepository.findAll();
//			userRepository.deleteAll(all);
		
		List<User> name = userRepository.findByName("sunil");
		name.forEach(n->{System.out.println(n);});
		
		List<User> nameAndCity = userRepository.findByNameAndCity("sunil", "bbsr");
		nameAndCity.forEach(nc->{System.out.println(nc);});
		
		List<User> users = userRepository.getAllUsers();
		users.forEach(e->{System.out.println(e);});
		
		List<User> userByName = userRepository.grtUserByName("susil");
		userByName.forEach(nm->{System.out.println(nm);});
		
		List<User> users2 = userRepository.getUsers();
		users2.forEach(r->{System.out.println(users2);});
	}
	

}
