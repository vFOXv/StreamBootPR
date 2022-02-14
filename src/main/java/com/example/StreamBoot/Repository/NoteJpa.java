package com.example.StreamBoot.Repository;

import com.example.StreamBoot.Models.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteJpa extends JpaRepository<Note, Long> {
    Note findNoteById(Long id);
}
