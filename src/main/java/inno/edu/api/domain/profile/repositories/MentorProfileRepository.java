package inno.edu.api.domain.profile.repositories;

import inno.edu.api.domain.profile.models.MentorProfile;
import inno.edu.api.domain.profile.models.ProfileStatus;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface MentorProfileRepository extends CrudRepository<MentorProfile, UUID> {
    List<MentorProfile> findBySchoolIdAndStatus(UUID schoolId, ProfileStatus status);
    List<MentorProfile> findByMentorId(UUID mentorId);
    MentorProfile findOneByMentorIdAndStatus(UUID mentorId, ProfileStatus status);
}