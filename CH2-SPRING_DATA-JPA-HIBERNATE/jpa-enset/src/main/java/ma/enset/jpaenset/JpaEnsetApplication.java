package ma.enset.jpaenset;
import ma.enset.jpaenset.entities.Role;
import ma.enset.jpaenset.entities.User;
import ma.enset.jpaenset.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;
@SpringBootApplication
public class JpaEnsetApplication {
    public static void main(String[] args) {
        SpringApplication.run(JpaEnsetApplication.class, args);
    }
    @Bean
    CommandLineRunner start(UserService userService){
        return args -> {
            User u1=new User();
            u1.setUsername("user1");
            u1.setPassword("123456");
            userService.addNewUser(u1);
            User u2=new User();
            u2.setUsername("admin");
            u2.setPassword("654321");
            userService.addNewUser(u2);
            Stream.of("USER","ADMIN","STUDENT").forEach(r->{
                Role role = new Role();
                role.setRoleName(r);
                userService.addNewRole(role);
                    });
        userService.addRoleToUser("user1","USER");
        userService.addRoleToUser("user1","STUDENT");
        userService.addRoleToUser("admin","ADMIN");
        userService.addRoleToUser("admin","USER");
        try {
            User user = userService.authenticate("user1","123456");
            System.out.println("Id : "+user.getUserId());
            System.out.println("UserName : "+user.getUsername());
            System.out.println("Roles : ");
            user.getRoles().forEach(r->{
                System.out.println("    Role : "+r);
            });
        }catch (Exception e){
            e.printStackTrace();
        }};}}
