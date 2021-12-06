package hello;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URL;
import java.util.Calendar;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloControllerTest {

    @Value("${local.server.port}")
    private int port;

    @Test
    public void renderTemplate() throws Exception {
        // given
        URL helloPage = new URL("http://localhost:" + port);

        // when
        String responseBody = Resources.toString(helloPage, Charsets.UTF_8);

        // then
        assertThat(responseBody, containsString("<title>Hello World!</title>"));
        assertThat(responseBody, containsString(String.valueOf(Calendar.getInstance().get(Calendar.YEAR))));
    }
}