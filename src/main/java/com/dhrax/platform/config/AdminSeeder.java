package com.dhrax.platform.config;

import com.dhrax.platform.entity.User;
import com.dhrax.platform.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;

@Configuration
@RequiredArgsConstructor
public class AdminSeeder implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
        if (userRepository.count() == 0) {
            User admin = User.builder()
                    .username("admin")
                    .email("admin@platform.com")
                    .passwordHash(passwordEncoder.encode("admin123"))
                    .role("ADMIN")
                    .createdAt(LocalDateTime.now())
                    .build();

            userRepository.save(admin);
        }
    }
}
