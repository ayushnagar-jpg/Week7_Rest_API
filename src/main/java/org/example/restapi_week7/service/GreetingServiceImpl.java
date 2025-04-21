package org.example.restapi_week7.service;

import org.example.restapi_week7.model.Greeting;
import org.example.restapi_week7.repository.GreetingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GreetingServiceImpl {

    private final GreetingRepository greetingRepository;

    public GreetingServiceImpl(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    public Greeting saveGreeting(String name) {
        String message = (name == null || name.trim().isEmpty())
                ? "Hello World"
                : String.format("Hello %s", name.trim());
        return greetingRepository.save(new Greeting(message));
    }

    public Greeting getGreeting(Long id) {
        return greetingRepository.findById(id).orElse(null);
    }

    public List<Greeting> getAllGreetings() {
        return greetingRepository.findAll();
    }
}


