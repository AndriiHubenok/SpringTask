package com.example.SpringTask;

import com.example.SpringTask.Migrations.Migration;
import org.flywaydb.core.Flyway;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringTaskApplication {

	public static void main(String[] args) {
		Migration migration = new Migration();
		migration.createNoteDatabase();
		SpringApplication.run(SpringTaskApplication.class, args);
	}
}
