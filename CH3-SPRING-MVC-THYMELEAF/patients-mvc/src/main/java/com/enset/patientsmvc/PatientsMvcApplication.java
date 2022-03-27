package com.enset.patientsmvc;

import com.enset.patientsmvc.entities.Patient;
import com.enset.patientsmvc.repositories.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class PatientsMvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatientsMvcApplication.class, args);
    }
        @Bean
        CommandLineRunner commandLineRunner(PatientRepository patientRepository){
        return args -> {
            patientRepository.save(new Patient(null,"Ouassime",new Date(),false,20));
            patientRepository.save(new Patient(null,"Ali",new Date(),true,30));
            patientRepository.save(new Patient(null,"Khadija",new Date(),true,10));
            patientRepository.save(new Patient(null,"Ikram",new Date(),false,9));

            patientRepository.findAll().forEach(patient -> {
                System.out.println(patient.getNom());
            });
        };
    }
}
