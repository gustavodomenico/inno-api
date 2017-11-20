package inno.edu.api.controllers.resources;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import inno.edu.api.controllers.MentorProfileController;
import inno.edu.api.controllers.SchoolController;
import inno.edu.api.controllers.UserController;
import inno.edu.api.domain.profile.models.MentorProfile;
import lombok.Getter;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.http.ResponseEntity;

import java.net.URI;

import static org.springframework.hateoas.core.DummyInvocationUtils.methodOn;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.http.ResponseEntity.created;
import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

@Getter
public class MentorProfileResource extends ResourceSupport {
    @JsonUnwrapped
    private final MentorProfile mentorProfile;

    public MentorProfileResource(MentorProfile mentorProfile) {
        this.mentorProfile = mentorProfile;
        add(linkTo(methodOn(MentorProfileController.class).get(mentorProfile.getId())).withSelfRel());
        add(linkTo(methodOn(UserController.class).get(mentorProfile.getMentorId())).withRel("mentor"));
        add(linkTo(methodOn(SchoolController.class).get(mentorProfile.getSchoolId())).withRel("school"));
    }

    public ResponseEntity<MentorProfile> toCreated() {
        return created(URI.create(getLink("self").getHref())).body(mentorProfile);
    }

    public ResponseEntity<MentorProfile> toUpdated() {
        return created(fromCurrentRequest().build().toUri()).body(mentorProfile);
    }
}
