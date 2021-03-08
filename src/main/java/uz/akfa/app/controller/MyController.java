package uz.akfa.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import uz.akfa.app.entity.Users;
import uz.akfa.app.service.UserServcie;

@RestController
@RequestMapping("/app")
public class MyController {
    @Autowired
    private UserServcie servcie;

    @PostMapping("/add_user")
    public String addUser(@RequestBody Users user) {
        System.out.println(user.getName());
        servcie.insertData(user);
        return "saved";
    }

    @GetMapping("/all")
    public Iterable<Users> getAllUSers() {
        return servcie.getAllData();
    }

    @GetMapping("/get_user/{id}")

    public Users getUserById(@PathVariable("id") Long id) {
        return servcie.getUserById(id);
    }

    @PutMapping("/update/{id}")
    public Users updateUserData(@PathVariable("id") Long id, @RequestBody Users userData) {
        Users u = servcie.updateData(id, userData);
        return u;
    }

    @DeleteMapping("/delete_by_id/{id}")
    public Iterable<Users> deleteById(@PathVariable("id") Long id) {
        return servcie.deleteById(id);
    }

    @DeleteMapping("/delete_by_user_data")
    public Iterable<Users> deleteByUserData(@RequestBody Users user) {
        return servcie.deleteByUser(user);
    }
}
