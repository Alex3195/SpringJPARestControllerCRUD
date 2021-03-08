package uz.akfa.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.akfa.app.entity.Users;
import uz.akfa.app.model.User;
import uz.akfa.app.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServcie {
    @Autowired
    private UserRepository repository;

    public List<User> getAllData() {
        Iterable<Users> list = repository.findAll();
        List<User> resList = new ArrayList<>();
        for (Users us : list) {
            User user = new User();
            user.setName(us.getName());
            user.setFullName(us.getFullName());
            user.setEmail(us.getEmail());
            user.setPassword(us.getPassword());
            resList.add(user);
        }
        return resList;
    }

    public void insertData(User user) {
        Users entity = new Users();
        entity.setName(user.getName());
        entity.setFullName(user.getFullName());
        entity.setEmail(user.getEmail());
        entity.setPassword(user.getPassword());
        repository.save(entity);
    }

    public User getUserById(Long id) {
        User user = new User();
        Users u = repository.findById(id).get();
        user.setName(u.getName());
        user.setFullName(u.getFullName());
        user.setEmail(u.getEmail());
        user.setPassword(u.getPassword());
        return user;
    }

    public User updateData(Long id, User userData) {

        User user = new User();
        Users userEntity = new Users();
        userEntity.setId(id);
        userEntity.setName(userData.getName());
        userEntity.setFullName(userData.getFullName());
        userEntity.setEmail(userData.getEmail());
        userEntity.setPassword(userData.getPassword());
        repository.save(userEntity);

        Users u = repository.findById(id).get();
        user.setName(u.getName());
        user.setFullName(u.getFullName());
        user.setEmail(u.getEmail());
        user.setPassword(u.getPassword());
        return user;
    }

    public List<User> deleteById(Long id) {
        repository.deleteById(id);
        Iterable<Users> list = repository.findAll();
        List<User> resList = new ArrayList<>();
        for (Users us : list) {
            User user = new User();
            user.setName(us.getName());
            user.setFullName(us.getFullName());
            user.setEmail(us.getEmail());
            user.setPassword(us.getPassword());
            resList.add(user);
        }
        return resList;
    }


    public User findByName(String name) {
        Users entity = repository.findByName(name);
        User user = new User();
        user.setName(entity.getName());
        user.setFullName(entity.getFullName());
        user.setEmail(entity.getEmail());
        user.setPassword(entity.getPassword());
        return user;
    }

    public User findByFullName(String fullName) {
        Users entity = repository.findByFullName(fullName);
        User user = new User();
        user.setName(entity.getName());
        user.setFullName(entity.getFullName());
        user.setEmail(entity.getEmail());
        user.setPassword(entity.getPassword());
        return user;
    }

    public List<User> findByEmail(String email) {
        List<Users> usersEntityList = repository.findByEmail(email);
        List<User> userList = new ArrayList<>();
        for (Users u : usersEntityList) {
            User user = new User();
            user.setName(u.getName());
            user.setFullName(u.getFullName());
            user.setEmail(u.getEmail());
            user.setPassword(u.getPassword());
            userList.add(user);
        }
        return userList;
    }
}
