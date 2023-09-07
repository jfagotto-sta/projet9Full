package com.projet9.Note.Controller;

import com.projet9.Note.Domain.Note;
import com.projet9.Note.Service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @GetMapping("/note/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Optional<Note> getNoteById(@PathVariable long id){
        return noteService.findNote(id);
    }

    @GetMapping("/notes/patient/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Note> getNotesForAPatient(@PathVariable long id){
        return noteService.findAllNotesForAPatient(id);}

    @GetMapping("/notes")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Note> getNotesForAPAtient(){
        return noteService.findAllNotes();}


    @DeleteMapping("/note/delete/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void deleteNoteById(@PathVariable long id){
       noteService.deleteNote(id);
    }

    @PostMapping("/note")
    @ResponseStatus(code = HttpStatus.OK)
    public void newNote(@RequestBody Note note){
        noteService.newNote(note);
    }

    @PostMapping("/patHistory/add")
    @ResponseStatus(code = HttpStatus.OK)
    public void newNote(@RequestBody String note){
        System.out.println(note);
        String[] infos = note.split("%C2");
        String idPatient = infos[0].split("=")[1];
        System.out.println("Id patient = "+idPatient);

        String[] notes = note.split("notes%2Frecommendations%3A+");
        String lesNotes = notes[1].replace('+',' ');
        //lesNotes = lesNotes.replaceAll("[^ a-zA-Z0-9]","");
        lesNotes = lesNotes.replaceAll("%27","");
        System.out.println("Les notes = "+lesNotes);

        Note noteObject = new Note();
        noteObject.setIdPatient(Long.parseLong(idPatient));
        noteObject.setMessageDate(new Date());
        noteObject.setMessage(lesNotes);
        noteService.newNote(noteObject);
    }

    @PutMapping(path = "/note/update", consumes= MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code=HttpStatus.OK)
    public Note updatePatientWithId(@RequestBody Note note) {return noteService.updatePatientData(note);
    }
}
