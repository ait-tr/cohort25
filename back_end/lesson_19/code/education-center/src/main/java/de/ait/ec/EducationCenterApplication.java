package de.ait.ec;

import de.ait.ec.repositories.UsersRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class EducationCenterApplication {

	public static void main(String[] args) {
		UsersRepository usersRepository = SpringApplication.run(EducationCenterApplication.class, args).getBean(UsersRepository.class);

		System.out.println(usersRepository.findFirst4ByOrderByIdDesc());

	}
}
