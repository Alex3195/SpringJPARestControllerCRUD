package uz.akfa.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import uz.akfa.app.entity.Users;

public interface UserRepository extends JpaRepository<Users, Long> {
    @Query("from Users u where u.name=?1")
    Users findByName(String name);

    @Query("from Users u where u.fullName=?1")
    Users findByFullName(String fullName);

    @Query("from Users u where u.email=?1")
    List<Users> findByEmail(String email);

    @Query("from Users u where u.password=?1")
    List<Users> findByPassword(String password);
}
