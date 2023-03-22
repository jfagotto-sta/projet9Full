package com.projet9.Note.Service;

import com.projet9.Note.Domain.Note;
import com.projet9.Note.Repository.INoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class NoteService {

    @Autowired
    private INoteRepository noteRepository;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;
    public Note createNote(Note note){
        return noteRepository.save(note);
    }

    public Optional<Note> findNote(long id) {
       return noteRepository.findById(id);
    }

    public List<Note> findAllNotesForAPatient(long id) {
        return noteRepository.findByIdPatient(id);
    }

    public void deleteNote(long id) {
        noteRepository.deleteById(id);
    }

    public void newNote(Note note) {
        note.setIdNote(sequenceGeneratorService.generateSequence(Note.SEQUENCE_NAME));
        noteRepository.save(note);
    }

    public Note updatePatientData(Note note) {
    return noteRepository.save(note);
    }

    public List<Note> findAllNotes() {
        return noteRepository.findAll();
    }
}
