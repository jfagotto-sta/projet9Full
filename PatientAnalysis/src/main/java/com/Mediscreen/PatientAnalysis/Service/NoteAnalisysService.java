package com.Mediscreen.PatientAnalysis.Service;
import com.Mediscreen.PatientAnalysis.Domain.Note;
import com.Mediscreen.PatientAnalysis.Domain.Patient;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class NoteAnalisysService {

    public int findTriggerForANote(List<Note> noteList){

        String[] symptomsToFInd = {"Hémoglobine A1C","Microalbumine","Taille","Microalbumine","Fumeur","Anormal","Cholestérol","Vertige","Rechute","Réaction","Anticorps"};

        List<String> stringList = Arrays.asList(symptomsToFInd);

        int counter = 0;

        for (Note note : noteList) {
            for (String symptomePossible: stringList) {
                if(note.getMessage().toUpperCase().contains(symptomePossible.toUpperCase())) {
                    counter++;
                }
            }
        }
        return counter;
    }
}
