package inno.edu.api.controllers.advices;

import inno.edu.api.domain.profile.exceptions.UserProfileNotFoundException;
import inno.edu.api.domain.user.exceptions.InvalidUsernameOrPasswordException;
import inno.edu.api.domain.user.exceptions.UserIsNotMentorException;
import inno.edu.api.domain.user.exceptions.UserNotFoundException;
import inno.edu.api.domain.user.exceptions.UsernameAlreadyExistsException;
import org.springframework.core.annotation.Order;
import org.springframework.hateoas.VndErrors.VndError;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.core.Ordered.HIGHEST_PRECEDENCE;

@ControllerAdvice
@Order(HIGHEST_PRECEDENCE)
public class UserControllerAdvice {

    @ResponseBody
    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    VndError userNotFoundExceptionHandler(UserNotFoundException ex) {
        return new VndError("error", ex.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(UsernameAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    VndError usernameAlreadyExistsExceptionHandler(UsernameAlreadyExistsException ex) {
        return new VndError("error", ex.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(UserProfileNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    VndError userProfileNotFoundExceptionHandler(UserProfileNotFoundException ex) {
        return new VndError("error", ex.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(InvalidUsernameOrPasswordException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    VndError invalidUserNameOrPasswordExceptionHandler(InvalidUsernameOrPasswordException ex) {
        return new VndError("error", ex.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(UserIsNotMentorException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    VndError userIsNotMentorExceptionHandler(UserIsNotMentorException ex) {
        return new VndError("error", ex.getMessage());
    }
}
