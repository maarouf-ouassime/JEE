package com.example.etudientapp;

import com.example.etudientapp.entities.Etudiant;
import com.example.etudientapp.entities.Genre;
import com.example.etudientapp.repositories.EtudiantRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class EtudientAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(EtudientAppApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(EtudiantRepository etudiantRepository){

        return args -> {
            etudiantRepository.save(new Etudiant(null,"Ouassime","Maarouf","a@a.com",new Date(),Genre.MASCULIN,false));
            etudiantRepository.save(new Etudiant(null,"Ali","Baba","b@b.com",new Date(),Genre.MASCULIN,false));
            etudiantRepository.save(new Etudiant(null,"Khadija","Sara","c@c.com",new Date(),Genre.FEMININ,true));
            etudiantRepository.save(new Etudiant(null,"Iman","Radi","d@d.com",new Date(),Genre.FEMININ,true));


            etudiantRepository.findAll().forEach(etudiant -> {
                System.out.println(etudiant.getNom());
            });
        };
    }
}
