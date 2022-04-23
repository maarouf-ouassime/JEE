package ma.enset.hospital.repositories;
import ma.enset.hospital.entities.Medcin;
import ma.enset.hospital.entities.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;
//public interface RendezVousRepository extends JpaRepository<RendezVous,Long> {
public interface RendezVousRepository extends JpaRepository<RendezVous,String> {
}
