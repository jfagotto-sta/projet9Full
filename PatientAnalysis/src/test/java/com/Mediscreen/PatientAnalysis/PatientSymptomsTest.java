package com.Mediscreen.PatientAnalysis;

import com.Mediscreen.PatientAnalysis.Domain.Note;
import com.Mediscreen.PatientAnalysis.Domain.Patient;
import com.Mediscreen.PatientAnalysis.Domain.PatientStatusDto;
import com.Mediscreen.PatientAnalysis.Service.PatientStatusService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class PatientSymptomsTest {

    @Autowired
    PatientStatusService patientStatusService;

    @Test
    public void hasNoRiskTest(){

        Patient patient = new Patient();
        List<Note> noteList = new ArrayList<>();
        Note note = new Note();
        note.setMessage("blabla");
        noteList.add(note);
        patient.setBirthDate(new Date(2000-07-07));
        patient.setGender("Male");

        patient.setNotes(noteList);

        PatientStatusDto patientStatusDto = patientStatusService.findPatientStatus(patient);

        assertTrue(patientStatusDto.isHasNoRisk());
    }

    @Test
    public void isBorderlineTest(){

        Patient patient = new Patient();
        List<Note> noteList = new ArrayList<>();
        Note note = new Note();
        note.setMessage("taille Microalbumine poids Fumeur");
        noteList.add(note);
        patient.setBirthDate(new Date(1980-07-07));
        patient.setGender("Male");

        patient.setNotes(noteList);

        PatientStatusDto patientStatusDto = patientStatusService.findPatientStatus(patient);

        assertTrue(patientStatusDto.isBorderline());
    }

    @Test
    public void isInDanger(){

        Patient patient = new Patient();
        List<Note> noteList = new ArrayList<>();
        Note note = new Note();
        note.setMessage("taille Microalbumine poids Fumeur");
        noteList.add(note);
        patient.setBirthDate(new Date(2010,07,07));
        patient.setGender("Female");

        patient.setNotes(noteList);

        PatientStatusDto patientStatusDto = patientStatusService.findPatientStatus(patient);

        assertTrue(patientStatusDto.isInDanger());
    }
}
