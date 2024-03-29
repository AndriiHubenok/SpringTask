package com.example.SpringTask.Controllers;

import com.example.SpringTask.Entity.Note;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/note")
public class NoteController {
    private Map<Long, Note> notes = new HashMap<>();
    private Long nextId = 1L;

    @GetMapping("/list")
    public String listNotes(Model model) {
        model.addAttribute("notes", new ArrayList<>(notes.values()));
        return "note-list";
    }

    @PostMapping("/delete")
    public String deleteNote(@RequestParam Long id) {
        notes.remove(id);
        return "redirect:/note/list";
    }

    @GetMapping("/edit")
    public String editNoteForm(@RequestParam Long id, Model model) {
        Note note = notes.get(id);
        model.addAttribute("note", note);
        return "note-edit";
    }

    @PostMapping("/edit")
    public String editNote(@ModelAttribute Note note) {
        notes.put(note.getId(), note);
        return "redirect:/note/list";
    }

    @GetMapping("/add")
    public String addNoteForm(Model model) {
        model.addAttribute("note", new Note());
        return "note-add";
    }

    @PostMapping("/add")
    public String addNote(@ModelAttribute Note note) {
        note.setId(nextId++);
        notes.put(note.getId(), note);
        return "redirect:/note/list";
    }
}
