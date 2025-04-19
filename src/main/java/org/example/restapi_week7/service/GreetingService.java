package org.example.restapi_week7.service;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    public String generateGreeting(String firstName, String lastName) {
        if (firstName != null && lastName != null) {
            return "Hello " + firstName + " " + lastName;
        } else if (firstName != null) {
            return "Hello " + firstName;
        } else if (lastName != null) {
            return "Hello " + lastName;
        } else {
            return "Hello World";
        }
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
