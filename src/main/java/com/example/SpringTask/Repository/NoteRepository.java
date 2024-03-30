package com.example.SpringTask.Repository;

import com.example.SpringTask.Entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {
}
