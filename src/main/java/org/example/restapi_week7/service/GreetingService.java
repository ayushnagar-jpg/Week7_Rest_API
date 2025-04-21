package org.example.restapi_week7.service;

import org.example.restapi_week7.model.Greeting;
import org.example.restapi_week7.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GreetingService {

    private static final String template = "Hello %s";
    private final GreetingRepository greetingRepository;

    @Autowired
    public GreetingService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    public Greeting saveGreeting(String name) {
        String message = (name == null || name.trim().isEmpty())
                ? "Hello World"
                : String.format(template, name.trim());
        return greetingRepository.save(new Greeting(message));
    }

    public Greeting getGreeting(Long id) {
        return greetingRepository.findById(id).orElse(null);
    }

    // ✅ UC6: Get all greetings
    public List<Greeting> getAllGreetings() {
        return greetingRepository.findAll();
    }

    public Greeting updateGreeting(Long id, Greeting newGreetingData) {
        return greetingRepository.findById(id)
                .map(greeting -> {
                    greeting.setMessage(newGreetingData.getMessage());
                    return greetingRepository.save(greeting);
                })
                .orElseThrow(() -> new RuntimeException("Greeting not found with id: " + id));
    }

    // UC8: Delete a greeting by ID
    public void deleteGreeting(Long id) {
        Greeting greeting = greetingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Greeting not found with id: " + id));
        greetingRepository.delete(greeting);
    }
}


