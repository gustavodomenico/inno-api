package inno.edu.api.controllers.advices;

import inno.edu.api.domain.school.exceptions.SchoolNotFoundException;
import org.springframework.hateoas.VndErrors.VndError;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class SchoolControllerAdvice {
    @ResponseBody
    @ExceptionHandler(SchoolNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    VndError schoolNotFoundExceptionHandler(SchoolNotFoundException ex) {
        return new VndError("error", ex.getMessage());
    }
}
