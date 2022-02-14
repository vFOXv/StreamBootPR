package com.example.StreamBoot.Controllers;

import com.example.StreamBoot.Models.Note;
import com.example.StreamBoot.Services.NoteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/show")
public class ShowController {

    private final NoteService noteService;

    public ShowController(NoteService noteService) {
        this.noteService = noteService;
    }

    //получение списка всех записей из DB и передача на отображение
    @GetMapping("/all")
    public String showAllNote(Model model){
        List <Note> notes = noteService.getAllNote();
        model.addAttribute("AllNotes", notes);
        model.addAttribute("DeleteThisNote","Delete");
        return "Show/show_all";
    }
}
