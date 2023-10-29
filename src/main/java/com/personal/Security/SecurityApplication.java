package com.personal.Security;

import com.personal.Security.repository.RoleRepository;
import com.personal.Security.repository.UserRepository;
import com.personal.Security.user.ApplicationUser;
import com.personal.Security.user.Role;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class SecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityApplication.class, args);
	}

	CommandLineRunner runner(RoleRepository roleRepository,
							 UserRepository userRepository,
							 PasswordEncoder passwordEncoder){
		return args -> {

			if (roleRepository.findByAuthority("ADMIN").isPresent()){
				return;
			}
			Role adminRole = new Role();
			adminRole.setAuthority("ADMIN");

			Role userRole = new Role();
			userRole.setAuthority("USER");

			roleRepository.save(adminRole);
			roleRepository.save(userRole);
			Set<Role> roleSet = new HashSet<>();
			roleSet.add(adminRole);

			ApplicationUser admin = new ApplicationUser();
			admin.setFirstName("Gozde");
			admin.setLastName("Apak");
			admin.setEmail("gozde@com.tr");
			admin.setPassword(passwordEncoder.encode("hello"));
			admin.setAuthorities(roleSet);
			userRepository.save(admin);


		};
	}
}
