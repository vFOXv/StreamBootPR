package com.example.StreamBoot.Services;

import com.example.StreamBoot.Models.Note;
import com.example.StreamBoot.Repository.NoteJpa;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class NoteService {

    private final NoteJpa noteJpa;

    public NoteService(NoteJpa noteJpa) {
        this.noteJpa = noteJpa;
    }

    //получение списка всех записей из BD
    public List<Note> getAllNote(){
        return noteJpa.findAll();
    }

    //получене текущей даты
    public Date getTodayDate(){
        return new Date();
    }

    //запись новой записи в BD
    public void saveNewNote(Note newNote){
        noteJpa.save(newNote);
    }

    //удаление записи из DB по id
    public void deleteNoteDb(Long id){
        noteJpa.delete(searchToId(id));
    }

    //поиск записи в DB по id
    public Note searchToId(Long id){
        return noteJpa.findNoteById(id);
    }
}
