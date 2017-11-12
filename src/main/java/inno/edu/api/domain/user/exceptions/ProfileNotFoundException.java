package inno.edu.api.domain.user.exceptions;

import java.util.UUID;

public class ProfileNotFoundException extends RuntimeException {
    public ProfileNotFoundException(UUID profileId) {
        super("Could not find profile '" + profileId.toString() + "'.");
    }
}