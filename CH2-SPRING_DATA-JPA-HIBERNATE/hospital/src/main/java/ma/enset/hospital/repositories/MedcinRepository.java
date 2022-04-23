package ma.enset.hospital.repositories;
import ma.enset.hospital.entities.Medcin;
import ma.enset.hospital.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
public interface MedcinRepository extends JpaRepository<Medcin,Long> {
    public Medcin findByNom(String nom);
}
