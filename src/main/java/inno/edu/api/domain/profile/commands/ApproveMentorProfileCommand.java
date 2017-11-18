package inno.edu.api.domain.profile.commands;

import inno.edu.api.domain.user.exceptions.ProfileNotFoundException;
import inno.edu.api.domain.user.models.MentorProfile;
import inno.edu.api.domain.user.models.ProfileStatus;
import inno.edu.api.domain.user.repositories.MentorProfileRepository;
import inno.edu.api.infrastructure.annotations.Command;

import java.util.UUID;

import static java.util.Optional.ofNullable;

@Command
public class ApproveMentorProfileCommand {
    private final MentorProfileRepository mentorProfileRepository;

    public ApproveMentorProfileCommand(MentorProfileRepository mentorProfileRepository) {
        this.mentorProfileRepository = mentorProfileRepository;
    }

    public void run(UUID profileId) {
        MentorProfile profile = ofNullable(mentorProfileRepository.findOne(profileId))
                .orElseThrow(() -> new ProfileNotFoundException(profileId));

        profile.setStatus(ProfileStatus.ACTIVE);
        mentorProfileRepository.save(profile);
    }
}