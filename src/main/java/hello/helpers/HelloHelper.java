package hello.helpers;

import pl.allegro.tech.boot.autoconfigure.handlebars.HandlebarsHelper;

@HandlebarsHelper
public class HelloHelper {

    public String sayHello(String name) {
        return String.format("Hello %s!", name == null ? "unknown" : name);
    }
}
