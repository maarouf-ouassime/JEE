package ma.enset.hospital;
import ma.enset.hospital.entities.*;
import ma.enset.hospital.repositories.ConsultationRepository;
import ma.enset.hospital.repositories.MedcinRepository;
import ma.enset.hospital.repositories.PatientRepository;
import ma.enset.hospital.repositories.RendezVousRepository;
import ma.enset.hospital.service.IHospitalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;
@SpringBootApplication
public class HospitalApplication {
	public static void main(String[] args) {
		SpringApplication.run(HospitalApplication.class, args);
	}
	@Bean
	//CommandLineRunner start(ConsultationRepository consultationRepository, PatientRepository patientRepository, MedcinRepository medcinRepository, RendezVousRepository rendezVousRepository){
	CommandLineRunner start(IHospitalService hospitalService,
							PatientRepository patientRepository,
							MedcinRepository medcinRepository,
							RendezVousRepository rendezVousRepository){
			return args -> {
			Stream.of("Mohammed","Ouassime","Khadija")
					.forEach(name->{
						Patient patient = new Patient();
						patient.setNom(name);
						patient.setDateNaissance(new Date());
						patient.setMalade(false);
						//patientRepository.save(patient);
						hospitalService.savePatient(patient);
							});
			Stream.of("Aymane","Hanane","Bilal")
					.forEach(name->{
						Medcin medcin = new Medcin();
						medcin.setNom(name);
						medcin.setSpecialite(Math.random()>0.5?"Cardio":"Dentiste");
						medcin.setEmail(name+"@gmail.com");
						//medcinRepository.save(medcin);
						hospitalService.saveMedcin(medcin);
					});
			Patient patient = patientRepository.findByNom("Ouassime");
			Medcin medcin = medcinRepository.findByNom("Hanane");
			RendezVous rendezVous = new RendezVous();
			rendezVous.setDate(new Date());
			rendezVous.setStatus(StatusRDV.PENDING);
			rendezVous.setPatient(patient);
			rendezVous.setMedcin(medcin);
			//rendezVousRepository.save(rendezVous);
				hospitalService.saveRDV(rendezVous);
			//RendezVous rendezVous1 = rendezVousRepository.findById(1L).orElse(null);
			RendezVous rendezVous1 = rendezVousRepository.findAll().get(0);
			Consultation consultation = new Consultation();
			consultation.setDateConsultation(new Date());
			consultation.setRendezVous(rendezVous1);
			consultation.setRapport("le rapport de la consultation ...");
			//consultationRepository.save(consultation);
				hospitalService.saveConsultation(consultation);
		};
	}
}
