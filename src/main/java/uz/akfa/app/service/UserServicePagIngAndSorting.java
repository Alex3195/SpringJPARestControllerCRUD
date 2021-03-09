package uz.akfa.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import uz.akfa.app.entity.Users;
import uz.akfa.app.model.User;
import uz.akfa.app.repository.PageableRepo;

@Service
public class UserServicePagIngAndSorting {
    @Autowired
    private PageableRepo repo;

    public List<User> getAllUser(int start, int size, String sort) {

        Pageable sorting = PageRequest.of(start-1, size, Sort.by(sort));
        Page<Users> pages = repo.findAll(sorting);
        List<User> resList = new ArrayList<>();

        if (pages.hasContent()) {
            List<Users> list = pages.getContent();
            for (Users us : list) {
                User u = new User();
                u.setName(us.getName());
                u.setFullName(us.getFullName());
                u.setEmail(us.getEmail());
                u.setPassword(us.getPassword());
                resList.add(u);
            }
        }else{
            return new ArrayList<>();
        }
        return resList;
    }

}
