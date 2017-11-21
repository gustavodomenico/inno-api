package inno.edu.api.controllers.advices;

import inno.edu.api.domain.profile.exceptions.ProfileNotFoundException;
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
public class MentorProfileControllerAdvice {

    @ResponseBody
    @ExceptionHandler(ProfileNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    VndError appointmentNotFoundExceptionHandler(ProfileNotFoundException ex) {
        return new VndError("error", ex.getMessage());
    }
}
