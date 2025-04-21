package org.example.restapi_week7.service;

import org.example.restapi_week7.model.Greeting;
import org.example.restapi_week7.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    private final GreetingRepository greetingRepository;

    @Autowired
    public GreetingService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    public Greeting saveGreeting(String message) {
        Greeting greeting = new Greeting();
        greeting.setMessage(message);
        return greetingRepository.save(greeting);
    }

    // Method to find a greeting by ID for UC5
    public Greeting getGreetingById(Long id) {
        return greetingRepository.findById(id).orElse(null); // Return null if not found
    }
}
