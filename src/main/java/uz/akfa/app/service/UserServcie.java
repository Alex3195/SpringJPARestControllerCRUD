package uz.akfa.app.service;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.akfa.app.entity.Users;
import uz.akfa.app.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserServcie {
    @Autowired
    private UserRepository repository;

    public List<Users> getAllData() {
        return (List<Users>) repository.findAll();
    }

    public void insertData(Users user) {
        repository.save(user);
    }

    public Users getUserById(Long id) {
        Optional<Users> u = repository.findById(id);
        return u.get();
    }

    public Users updateData(Long id, Users userData) {
        Users exactData = repository.findById(id).get();
        exactData.setName(userData.getName());
        exactData.setFullName(userData.getFullName());
        exactData.setEmail(userData.getEmail());
        exactData.setPassword(userData.getPassword());
        repository.save(exactData);
        return repository.findById(id).get();
    }

    public Iterable<Users> deleteById(Long id) {
        repository.deleteById(id);
        return repository.findAll();
    }

    public Iterable<Users> deleteByUser(Users u){
        repository.delete(u);
        return repository.findAll();
    }
}
