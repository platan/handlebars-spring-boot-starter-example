package hello;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.net.URL;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest({"server.port=0"})
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
        assertThat(responseBody, equalTo("Hello World!"));
    }
}