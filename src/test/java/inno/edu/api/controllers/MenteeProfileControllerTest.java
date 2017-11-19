package inno.edu.api.controllers;

import inno.edu.api.controllers.resources.MenteeProfileResource;
import inno.edu.api.controllers.resources.ResourceBuilder;
import inno.edu.api.domain.profile.commands.CreateMenteeProfileCommand;
import inno.edu.api.domain.profile.commands.DeleteMenteeProfileCommand;
import inno.edu.api.domain.profile.commands.UpdateMenteeProfileCommand;
import inno.edu.api.domain.profile.models.MenteeProfile;
import inno.edu.api.domain.profile.queries.GetMenteeProfileByIdQuery;
import inno.edu.api.domain.profile.repositories.MenteeProfileRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.ServletRequestAttributes;

import static inno.edu.api.support.ProfileFactory.alanProfile;
import static inno.edu.api.support.ProfileFactory.menteeProfiles;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentCaptor.forClass;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.web.context.request.RequestContextHolder.setRequestAttributes;

@RunWith(MockitoJUnitRunner.class)
public class MenteeProfileControllerTest {
    @Mock
    private ResourceBuilder resourceBuilder;

    @Mock
    private GetMenteeProfileByIdQuery getMenteeProfileByIdQuery;

    @Mock
    private MenteeProfileRepository menteeProfileRepository;

    @Mock
    private CreateMenteeProfileCommand createMenteeProfileCommand;

    @Mock
    private UpdateMenteeProfileCommand updateMenteeProfileCommand;

    @Mock
    private DeleteMenteeProfileCommand deleteMenteeProfileCommand;

    @InjectMocks
    private MenteeProfileController menteeProfileController;

    @Before
    public void setup() {
        setRequestAttributes(new ServletRequestAttributes(new MockHttpServletRequest()));
    }

    @Test
    public void shouldGetProfileById() {
        when(getMenteeProfileByIdQuery.run(eq(alanProfile().getId()))).thenReturn(alanProfile());

        MenteeProfileResource profileResource = menteeProfileController.get(alanProfile().getId());

        assertThat(profileResource.getMenteeProfile(), is(alanProfile()));
    }

    @Test
    public void shouldListProfiles() {
        when(menteeProfileRepository.findAll()).thenReturn(menteeProfiles());

        menteeProfileController.all();

        verify(resourceBuilder).from(eq(menteeProfiles()), any());
    }

    @Test
    public void shouldCreateNewProfiles() {
        ArgumentCaptor<MenteeProfile> argumentCaptor = forClass(MenteeProfile.class);
        when(createMenteeProfileCommand.run(argumentCaptor.capture())).thenReturn(alanProfile());

        menteeProfileController.post(alanProfile());

        verify(createMenteeProfileCommand).run(argumentCaptor.capture());
    }

    @Test
    public void shouldUpdateUser() {
        when(updateMenteeProfileCommand.run(alanProfile().getId(), alanProfile())).thenReturn(alanProfile());

        menteeProfileController.put(alanProfile().getId(), alanProfile());

        verify(updateMenteeProfileCommand).run(alanProfile().getId(), alanProfile());
    }

    @Test
    public void shouldDeleteUser() {
        menteeProfileController.delete(alanProfile().getId());

        verify(deleteMenteeProfileCommand).run(alanProfile().getId());
    }
}