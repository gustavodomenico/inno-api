package inno.edu.api;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class DummyTest {

    @Test
    public void dummyTest() {
        assertThat("Hello World!", is("Hello World!"));
    }
}