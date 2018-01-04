package inno.edu.api.domain.user.repositories;

import inno.edu.api.domain.user.models.ApplicationUser;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface UserRepository extends CrudRepository<ApplicationUser, UUID> {
    ApplicationUser findOneByUsernameAndPassword(String username, String password);
    ApplicationUser findOneByUsername(String username);
    boolean existsByUsername(String username);
}