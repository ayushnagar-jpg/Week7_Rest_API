package org.example.restapi_week7.service;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    public String getGreeting() {
        return "Hello from GET Request By Ayush";
    }

    public String postGreeting() {
        return "Hello from POST Request By Ayush";
    }

    public String putGreeting() {
        return "Hello from PUT Request By Ayush";
    }

    public String deleteGreeting() {
        return "Hello from DELETE By Ayush";
    }
}
