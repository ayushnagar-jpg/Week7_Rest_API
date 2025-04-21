package org.example.restapi_week7.Controller;

import org.example.restapi_week7.model.Greeting;
import org.example.restapi_week7.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/greeting")
public class GreetingController {

    private final GreetingService greetingService;

    @Autowired
    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    // UC4: Save a new greeting
    @PostMapping("/save")
    public Greeting saveGreeting(@RequestBody String message) {
        return greetingService.saveGreeting(message);
    }

    // UC5: Get greeting by ID
    @GetMapping("/{id}")
    public Greeting getGreeting(@PathVariable Long id) {
        return greetingService.getGreeting(id);
    }

    // ✅ UC6: Get all greetings
    @GetMapping("/all")
    public List<Greeting> getAllGreetings() {
        return greetingService.getAllGreetings();
    }

    // UC7: Update greeting by ID
    @PutMapping("/{id}")
    public ResponseEntity<Greeting> updateGreeting(@PathVariable Long id, @RequestBody Greeting updatedGreeting) {
        Greeting greeting = greetingService.updateGreeting(id, updatedGreeting);
        return ResponseEntity.ok(greeting);
    }

    // UC8: Delete greeting by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGreeting(@PathVariable Long id) {
        greetingService.deleteGreeting(id);
        return ResponseEntity.noContent().build();
    }
}
