package com.example.StreamBoot.Controllers;
import com.example.StreamBoot.Models.Note;

import com.example.StreamBoot.Services.NoteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


@Controller
@RequestMapping("/action")
public class ActionController {

    private final NoteService noteService;

    public ActionController(NoteService noteService) {
        this.noteService = noteService;
    }

    //создает модель и предает ее на страницу HTML для создания новой записи в DB
    @GetMapping("/recordInDb")
    public String openPageRecordInDb(Model model) {
        Note note = new Note();
        // установка даты в новую запись
        note.setDate(noteService.getTodayDate());
        model.addAttribute("newNote", note);
        return "Action/record_in_db";
    }

    //получение данных о новой записи и запись ее в DB
    @PostMapping("/recordInDb")
    public String recordInDbNewNote(@ModelAttribute("newNote") @Valid Note newNote,
                                    BindingResult bindingResult) {
        //записываем дату до проверки ошибки, иначе падает из за пустого поля(в модели стоит анатация NotNull)
        newNote.setDate(noteService.getTodayDate());
        if(bindingResult.hasErrors()){
            return "Action/record_in_db";
        }
        System.out.println("------------------------------>" + newNote);
        noteService.saveNewNote(newNote);
        return "redirect:/show/all";
    }

    //удаление выбранного текста из DB
    @GetMapping("/removeNote/{id}")
    public String deleteNote(@PathVariable("id") Long id) {
        noteService.deleteNoteDb(id);
        return "redirect:/show/all";
    }

    //создает модель и предает ее на страницу HTML для создания новой записи в файл
    @GetMapping("/recordInFile")
    public String openPageRecordInFile(Model model) {
        Note note = new Note();
        // установка даты в новую запись
        note.setDate(noteService.getTodayDate());
        model.addAttribute("newNote", note);
        return "Action/record_in_file";
    }

    //получение данных о новой записи и запись ее в файл
    @PostMapping("/recordInFile")
    public String recordInFileNewNote(@ModelAttribute("newNote") Note newNote, Model model) {
        File file = new File("./src/main/resources/RecordFile", "Hello_My_Text.txt");
        try (FileWriter writer = new FileWriter(file, false)) {
            String text = newNote.getText();
            writer.write(text);
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        model.addAttribute("Message", "Check your file!");
        return "Action/message";
    }

    //чтение данных из файла и передача текста на HTML страницу
    @GetMapping("/inputInHTML")
    public String inputTextFromFileInHtml(Model model) {
        StringBuilder str = new StringBuilder();
        File file = new File("./src/main/resources/RecordFile", "Hello_My_Text.txt");
        try (FileReader reader = new FileReader(file)) {
            int myChar;
            while ((myChar = reader.read()) != -1) {
                str.append((char) myChar);

            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        if (str.length() != 0) {
            model.addAttribute("ThisText", str);
        } else {
            model.addAttribute("ThisText", "This file is empty!!!");
        }
        return "Action/input_in_html";
    }
}
