package pl.oremczuk.springsecurityjpamysql;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleApi {

    @GetMapping("/")
    public String homeWelcome() {
        return "<h1>Welcome</h1>";
    }

    @GetMapping("/user")
    public String userWelcome() {
        return "<h1>Welcome user<h1>";

    }
    @GetMapping("/admin")
    public String adminWelcome() {
        return "<h1>Welcome admin<h1>";

    }


}
