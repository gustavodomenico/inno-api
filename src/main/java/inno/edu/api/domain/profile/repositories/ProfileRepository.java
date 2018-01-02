package inno.edu.api.domain.profile.repositories;

import inno.edu.api.domain.profile.models.Profile;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ProfileRepository  extends CrudRepository<Profile, UUID> {
    boolean existsByUserId(UUID menteeId);
}