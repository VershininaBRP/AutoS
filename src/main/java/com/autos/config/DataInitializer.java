package com.autos.config;

import com.autos.entity.User;
import com.autos.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {

        // Добавляем администратора, если его нет
        if (userRepository.findByUsername("admin").isEmpty()) {
            User admin = new User();
            admin.setUsername("admin");
            admin.setPassword(passwordEncoder.encode("password"));
            admin.setPhone("+71234567890");
            admin.setRole("ADMIN");
            userRepository.save(admin);
            System.out.println("✅ Администратор admin добавлен!");
        } else {
            // Обновляем пароль админа на правильный
            User admin = userRepository.findByUsername("admin").get();
            admin.setPassword(passwordEncoder.encode("password"));
            userRepository.save(admin);
            System.out.println("✅ Пароль администратора обновлён!");
        }

        System.out.println("🎉 Вход: admin / password");
    }
}