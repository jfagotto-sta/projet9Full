package com.Mediscreen.PatientAnalysis.Service;

import com.Mediscreen.PatientAnalysis.Domain.Patient;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.core.MediaType;
import org.springframework.stereotype.Service;

@Service
public class PatientService {


    public Patient getPatient(Long id ) {
        Client client = ClientBuilder.newClient();

        Patient response = client.target("http://patient:8089/patientSansStatus/"+id)
                .request(MediaType.APPLICATION_JSON)
                .get(Patient.class);
        return response;
    }
}
