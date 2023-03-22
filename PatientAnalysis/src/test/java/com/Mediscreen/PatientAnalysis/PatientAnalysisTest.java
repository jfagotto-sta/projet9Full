package com.Mediscreen.PatientAnalysis;

import com.Mediscreen.PatientAnalysis.Domain.Note;
import com.Mediscreen.PatientAnalysis.Domain.Patient;
import com.Mediscreen.PatientAnalysis.Service.NoteAnalisysService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.springframework.test.util.AssertionErrors.assertEquals;

@SpringBootTest
public class PatientAnalysisTest {


    @Autowired
    NoteAnalisysService noteAnalisysService;

    @Test
    public void patientAnalysisTest(){
        List<Note> noteList = new ArrayList<>();

        Patient patient = new Patient();
        patient.setGender("Male");
        patient.setBirthDate(new Date(1980-10-10));

        Note note = new Note();
        note.setMessage("test test test Microalbumine Poids ");
        noteList.add(note);


        patient.setNotes(noteList);

        int symptomsToFind = noteAnalisysService.findTriggerForANote(noteList);

        Assertions.assertEquals(2,symptomsToFind);
    }

    @Test
    public void test(){
        List<Note> noteList = new ArrayList<>();

        Patient patient = new Patient();
        patient.setGender("Male");
        patient.setBirthDate(new Date(1980-10-10));

        Note note = new Note();
        note.setMessage("Hémoglobine A1C test ttt ttTaille qsdsdf  ");
        noteList.add(note);


        patient.setNotes(noteList);

        int symptomsToFind = noteAnalisysService.findTriggerForANote(noteList);

        Assertions.assertEquals(2,symptomsToFind);
    }
}
