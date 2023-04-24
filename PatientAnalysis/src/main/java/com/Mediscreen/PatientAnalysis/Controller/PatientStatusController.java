package com.Mediscreen.PatientAnalysis.Controller;

import com.Mediscreen.PatientAnalysis.Domain.Patient;
import com.Mediscreen.PatientAnalysis.Domain.PatientStatusDto;
import com.Mediscreen.PatientAnalysis.Service.PatientService;
import com.Mediscreen.PatientAnalysis.Service.PatientStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins="http://localhost:8089")
public class PatientStatusController {

    @Autowired
    PatientService patientService;

    @Autowired
    PatientStatusService patientStatusService;

    @GetMapping(path = "patient/status/{id}", produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.OK)
    public PatientStatusDto findStatusForAPatient(@PathVariable("id") Long idPatient){
        Patient patient = patientService.getPatient(idPatient);
        return patientStatusService.findPatientStatus(patient);
    }
}
