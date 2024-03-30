package com.example.SpringTask;

import org.flywaydb.core.Flyway;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringTaskApplication {

	public static void main(String[] args) {
		Flyway flyway = Flyway.configure()
				.dataSource("jdbc:h2:/Users/user/IdeaProjects/SpringTask/base", "sa", null)
				.load();

		flyway.migrate();
		SpringApplication.run(SpringTaskApplication.class, args);
	}

}
