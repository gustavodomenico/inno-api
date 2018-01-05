package inno.edu.api.domain.profile.root.assertions;

import inno.edu.api.domain.profile.root.exceptions.ProfileNotFoundException;
import inno.edu.api.domain.profile.root.repositories.ProfileRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static inno.edu.api.support.ProfileFactory.alanProfile;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProfileExistsAssertionTest {
    @Mock
    private ProfileRepository profileRepository;

    @InjectMocks
    private ProfileExistsAssertion profileExistsAssertion;

    @Test(expected = ProfileNotFoundException.class)
    public void shouldThrowExceptionIfProfileDoesNotExist() {
        when(profileRepository.exists(alanProfile().getId())).thenReturn(false);

        profileExistsAssertion.run(alanProfile().getId());
    }

    @Test
    public void shouldNotThrowExceptionIfProfileExists() {
        when(profileRepository.exists(alanProfile().getId())).thenReturn(true);

        profileExistsAssertion.run(alanProfile().getId());
    }
}