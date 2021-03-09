package uz.akfa.app.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import uz.akfa.app.entity.Users;

public interface PageableRepo extends PagingAndSortingRepository<Users, Long> {
}
