package com.example.SpringTask.Migrations;

import org.flywaydb.core.Flyway;

public class Migration {
    public void createNoteDatabase() {
        Flyway flyway = Flyway.configure()
                .dataSource("jdbc:h2:mem:testdb", "sa", null)
                .load();

        flyway.migrate();
    }
}
