package inno.edu.api.domain.user.exceptions;

import java.util.UUID;

public class UserIsNotMenteeException extends RuntimeException {
    public UserIsNotMenteeException(UUID userId) {
        super("User '" + userId.toString() + "' is not a mentee.");
    }
}
