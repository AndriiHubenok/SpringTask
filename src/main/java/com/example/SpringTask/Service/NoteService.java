package com.example.SpringTask.Service;

import com.example.SpringTask.Entity.Note;
import com.example.SpringTask.Repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {
    private final NoteRepository noteRepository;

    @Autowired
    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public List<Note> listAll() {
        return noteRepository.findAll();
    }

    public Note add(Note note) {
        return noteRepository.save(note);
    }

    public void deleteById(long id) {
        noteRepository.findById(id).ifPresentOrElse(
                noteRepository::delete,
                () -> { throw new IllegalArgumentException("Note with id " + id + " not found"); }
        );
    }

    public void update(Note note) {
        if (!noteRepository.existsById(note.getId())) {
            throw new IllegalArgumentException("Note with id " + note.getId() + " not found");
        }
        noteRepository.save(note);
    }

    public Note getById(long id) {
        return noteRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Note with id " + id + " not found")
        );
    }
}
