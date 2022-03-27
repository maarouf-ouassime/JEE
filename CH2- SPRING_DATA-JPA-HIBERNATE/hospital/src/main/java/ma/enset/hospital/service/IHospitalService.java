package ma.enset.hospital.service;
import ma.enset.hospital.entities.Consultation;
import ma.enset.hospital.entities.Medcin;
import ma.enset.hospital.entities.Patient;
import ma.enset.hospital.entities.RendezVous;
public interface IHospitalService {
    Patient savePatient(Patient patient);
    Medcin saveMedcin(Medcin medcin);
    RendezVous saveRDV(RendezVous rendezVous);
    Consultation saveConsultation(Consultation consultation);
}
