package inno.edu.api.domain.profile.repositories;

import inno.edu.api.domain.profile.models.ProfileAssociation;
import inno.edu.api.domain.profile.models.RequestStatus;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ProfileAssociationRepository extends CrudRepository<ProfileAssociation, UUID> {
    boolean existsOneByProfileIdAndStatus(UUID profileId, RequestStatus status);
}