package com.example.etudientapp;

import com.example.etudientapp.entities.Etudiant;
import com.example.etudientapp.entities.Genre;
import com.example.etudientapp.repositories.EtudiantRepository;
import com.example.etudientapp.security.service.SecurityService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

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
   // @Bean
    CommandLineRunner saveUsers(SecurityService securityService){
        return args -> {
            securityService.saveNewUser("ouassime","1234","1234");
            securityService.saveNewUser("maarouf","1234","1234");
            securityService.saveNewUser("wissam","1234","1234");

            securityService.saveNewRole("USER","");
            securityService.saveNewRole("ADMIN","");

            securityService.addRoleToUser("maarouf","ADMIN");
            securityService.addRoleToUser("maarouf","USER");
            securityService.addRoleToUser("ouassime","USER");
            securityService.addRoleToUser("wissam","USER");
        };
    }
    @Bean
    PasswordEncoder passwordEncoder(){ return new BCryptPasswordEncoder();
    }
}
