package io.github.dbarrerap.picbucket;

import io.github.dbarrerap.picbucket.entities.Role;
import io.github.dbarrerap.picbucket.entities.User;
import io.github.dbarrerap.picbucket.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class PicBucketApplication {

    public static void main(String[] args) {
        SpringApplication.run(PicBucketApplication.class, args);
    }

    /*@Bean
    CommandLineRunner runner(UserService service) {
        return args -> {
            service.saveRole(new Role(null, "ROLE_USER"));
            service.saveRole(new Role(null, "ROLE_ADMIN"));

            service.saveUser(new User(null, "David Barrera", "dbarrerap@live.com", "p4ssw0rd", new ArrayList<>()));
            service.saveUser(new User(null, "Paola Gallo", "paola@email.com", "p4ssw0rd", new ArrayList<>()));
            service.saveUser(new User(null, "Paula Barrera", "pdbarrera@email.com", "p4ssw0rd", new ArrayList<>()));

            service.assignRole("dbarrerap@live.com", "ROLE_USER");
            service.assignRole("dbarrerap@live.com", "ROLE_ADMIN");
            service.assignRole("paola@email.com", "ROLE_USER");
            service.assignRole("pdbarrera@email.com", "ROLE_USER");
        };
    }*/

}
