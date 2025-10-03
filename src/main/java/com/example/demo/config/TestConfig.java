package com.example.demo.config;

import com.example.demo.entities.Order;
import com.example.demo.entities.User;
import com.example.demo.entities.enums.OrderStatus;
import com.example.demo.repositories.OrderRepository;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "984845454", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "9123335454", "123456");

        Order o1 = new Order(null, Instant.parse("2025-09-10T19:52:07Z"), OrderStatus.PAID,u1);
        Order o2 = new Order(null, Instant.parse("2025-08-25T16:52:07Z"), OrderStatus.WAITING_PAYMENT, u2);
        Order o3 = new Order(null, Instant.parse("2025-07-21T08:52:07Z"), OrderStatus.WAITING_PAYMENT, u1);

        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));
    }
}
