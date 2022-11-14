package com.example.demo;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
   private 	UserRepository repo;

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		User user=new User();

		 user.setUsername("musarao");
		 user.setEmail("musarao123@gmail.com");
		 user.setPassword(bCryptPasswordEncoder.encode("12345"));
		 user.setRole("ROLE_ADMIN");

		 this.repo.save(user);

		User user1=new User();

		user1.setUsername("hamidi");
		user1.setEmail("hamidi123@gmail.com");
		user1.setPassword(bCryptPasswordEncoder.encode("6789"));
		user1.setRole("ROLE_USER");

		this.repo.save(user1);



	}
}
