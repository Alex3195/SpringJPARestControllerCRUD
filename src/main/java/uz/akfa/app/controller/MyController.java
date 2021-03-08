package uz.akfa.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import lombok.extern.log4j.Log4j2;
import uz.akfa.app.model.User;
import uz.akfa.app.service.UserServcie;

@RestController
@Log4j2
@RequestMapping("/app")
public class MyController {

    @Autowired
    private UserServcie servcie;

    @PostMapping("/add_user")
    public String addUser(@RequestBody User user) {
        servcie.insertData(user);
        log.trace("saved");
        return "saved";
    }

    @GetMapping("/all")
    public List<User> getAllUSers() {
        return servcie.getAllData();
    }

    @GetMapping("/get_user/{id}")

    public User getUserById(@PathVariable("id") Long id) {
        return servcie.getUserById(id);
    }

    @PutMapping("/update/{id}")
    public User updateUserData(@PathVariable("id") Long id, @RequestBody User userData) {
        return servcie.updateData(id, userData);
    }

    @DeleteMapping("/delete_by_id/{id}")
    public List<User> deleteById(@PathVariable("id") Long id) {
        return servcie.deleteById(id);
    }

    @GetMapping("/get_by_name")
    public List<User> getByName(@RequestParam("email") String email) {
        return servcie.findByEmail(email);

    }
}
