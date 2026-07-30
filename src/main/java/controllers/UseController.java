package controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sanjana.springboot_beginner.models.User;
import com.sanjana.springboot_beginner.services.UserService;

@RestController
@RequestMapping("/api/users")

public class UseController {
    private UserService userService;
    
     public UseController(UserService userService) {
        this.userService = userService;
     }
     
     @GetMapping

     public List<User> getAllUsers() {
        return userService.getAllUsers();
     }

     @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id) {
        User temp = userService.getUserById(id);
        if (temp != null) {
            return ResponseEntity.ok(temp);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @PostMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable int id, @RequestBody User updatedUser) {
        User temp = userService.updateUser(id, updatedUser);
        if (temp != null) {
            return ResponseEntity.ok(temp);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{id}/delete")
    public ResponseEntity<Boolean> deleteUser(@PathVariable int id) {
        boolean temp = userService.deleteUser(id);
        if (temp) {
            return ResponseEntity.ok(true);
        } else {
            return ResponseEntity.notFound().build();
        }
    }       



}
