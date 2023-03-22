package com.Mediscreen.PatientAnalysis.Service;

import com.Mediscreen.PatientAnalysis.Domain.Patient;
import com.Mediscreen.PatientAnalysis.Domain.PatientStatusDto;
import com.Mediscreen.PatientAnalysis.Utils.AgeCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientStatusService {

    @Autowired
    NoteAnalisysService noteAnalisysService;



    public PatientStatusDto findPatientStatus(Patient patient){

        int patientSymptoms = noteAnalisysService.findTriggerForANote(patient.getNotes());
        PatientStatusDto patientStatus = new PatientStatusDto();


        //patient sans risque
        if(patientSymptoms < 2) {
            patientStatus.setHasNoRisk(true);
        }
        //patient > 30 ans
        else if(AgeCalculator.getAgeFromBirthdate(patient.getBirthDate()) > 30) {
            if(patientSymptoms > 7) {
                patientStatus.setSubjectToEarlyOnSetRisk(true);
            } else if(patientSymptoms > 5) {
                patientStatus.setInDanger(true);
            } else {
                patientStatus.setBorderline(true);
            }
        }
        //patient < 30ans
        else {
            if(patientSymptoms > 4 && patient.getGender().equals("Male")) {
                patientStatus.setSubjectToEarlyOnSetRisk(true);
            } else if(patientSymptoms > 2 && patient.getGender().equals("Male")) {
                patientStatus.setInDanger(true);
            } else if(patientSymptoms > 6 && patient.getGender().equals("Female")) {
                patientStatus.setSubjectToEarlyOnSetRisk(true);
            } else if(patientSymptoms > 3 && patient.getGender().equals("Female")) {
                patientStatus.setInDanger(true);
            }
        }

        return patientStatus;
    }
}
