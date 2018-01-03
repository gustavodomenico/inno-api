package inno.edu.api.domain.profile.commands;

import inno.edu.api.domain.profile.commands.mappers.UpdateProfileRequestMapper;
import inno.edu.api.domain.profile.models.Profile;
import inno.edu.api.domain.profile.queries.GetProfileByIdQuery;
import inno.edu.api.domain.profile.repositories.ProfileRepository;
import inno.edu.api.support.ProfileFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static inno.edu.api.support.ProfileFactory.updateAlanProfileRequest;
import static inno.edu.api.support.ProfileFactory.updatedAlanProfile;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UpdateProfileCommandTest {
    @Mock
    private UpdateProfileRequestMapper updateProfileRequestMapper;

    @Mock
    private ProfileRepository profileRepository;

    @Mock
    private GetProfileByIdQuery getProfileByIdQuery;

    @InjectMocks
    private UpdateProfileCommand updateProfileCommand;

    @Test
    public void shouldReturnUpdatedProfile() {
        when(getProfileByIdQuery.run(ProfileFactory.alanProfile().getId())).thenReturn(ProfileFactory.alanProfile());
        when(profileRepository.save(ProfileFactory.alanProfile())).thenReturn(updatedAlanProfile());

        Profile Profile = updateProfileCommand.run(ProfileFactory.alanProfile().getId(), updateAlanProfileRequest());

        verify(updateProfileRequestMapper).setProfile(updateAlanProfileRequest(), ProfileFactory.alanProfile());

        assertThat(Profile, is(updatedAlanProfile()));
    }
}