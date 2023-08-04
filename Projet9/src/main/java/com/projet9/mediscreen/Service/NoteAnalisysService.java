package com.projet9.mediscreen.Service;


import com.projet9.mediscreen.Domain.NoteDTO;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class NoteAnalisysService {

    public int findTriggerForANote(List<NoteDTO> noteList){

        String[] symptomsToFInd = {"Hémoglobine A1C","Microalbumine","Taille","Microalbumine","Fumeur","Anormal","Cholestérol","Vertige","Rechute","Réaction","Anticorps"};

        List<String> stringList = Arrays.asList(symptomsToFInd);

        int counter = 0;

        for (NoteDTO note : noteList) {
            for (String symptomePossible: stringList) {
                if(note.getMessage().toUpperCase().contains(symptomePossible.toUpperCase())) {
                    counter++;
                }
            }
        }
        return counter;
    }
}
