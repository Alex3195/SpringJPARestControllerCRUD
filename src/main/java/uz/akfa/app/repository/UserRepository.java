package uz.akfa.app.repository;

import org.springframework.data.repository.CrudRepository;
import uz.akfa.app.entity.Users;

public interface UserRepository extends CrudRepository<Users,Long> {
}
