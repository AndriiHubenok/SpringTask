package com.example.SpringTask.Service;

import com.example.SpringTask.Entity.Note;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class NoteService {
    private final Map<Long, Note> notes = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong();

    public List<Note> listAll() {
        return new ArrayList<>(notes.values());
    }

    public Note add(Note note) {
        long id = idGenerator.incrementAndGet();
        note.setId(id);
        notes.put(id, note);
        return note;
    }

    public void deleteById(long id) {
        if (!notes.containsKey(id)) {
            throw new IllegalArgumentException("Note with id " + id + " not found");
        }
        notes.remove(id);
    }

    public void update(Note note) {
        if (!notes.containsKey(note.getId())) {
            throw new IllegalArgumentException("Note with id " + note.getId() + " not found");
        }
        notes.put(note.getId(), note);
    }

    public Note getById(long id) {
        Note note = notes.get(id);
        if (note == null) {
            throw new IllegalArgumentException("Note with id " + id + " not found");
        }
        return note;
    }
}