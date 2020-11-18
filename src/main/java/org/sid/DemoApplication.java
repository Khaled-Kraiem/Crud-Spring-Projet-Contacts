package org.sid;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.sid.dao.ContactRepository;
import org.sid.entities.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	@Autowired
	private ContactRepository contactRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		DateFormat df =new SimpleDateFormat("dd/MM/yyy");
		contactRepository.save(new Contact("Khaled", "Kraiem", df.parse("02/11/1991"), "khaled.kraiem.91@gmail.com", 25413070, "khaled.jpg"));
		contactRepository.save(new Contact("Sarra", "BenAhmed", df.parse("19/03/1998"), "sarra.ahmed@gmail.com", 25413070, "sarra.jpg"));
		contactRepository.findAll().forEach(c->{
			System.out.println(c.getNom());
		});
	}

}
