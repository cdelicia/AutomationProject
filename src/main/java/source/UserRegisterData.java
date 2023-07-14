package source;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import static source.Constants.TEST_PASSWORD;

public class UserRegisterData {
    public String email;
    public String name;
    public String group;
    public String password;

    public UserRegisterData() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ddHHmmss");
        LocalDateTime now = LocalDateTime.now();
        this.email = "autogen"+dtf.format(now)+"@email.com";
        this.name = "John Snow";
        this.password = TEST_PASSWORD;
        this.group = "ApiTest";
    }

    public UserRegisterData(String name) {
        this.name = name;
    }
}
