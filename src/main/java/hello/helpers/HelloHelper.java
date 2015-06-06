package hello.helpers;

import com.google.common.base.Objects;
import pl.allegro.tech.boot.autoconfigure.handlebars.HandlebarsHelper;

@HandlebarsHelper
public class HelloHelper {

    public String sayHello(String name) {
        return String.format("Hello %s!", Objects.firstNonNull(name, "unknown"));
    }
}
