package source;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import static source.Constants.TEST_PASSWORD;

public class UserRegisterData {
    public String email;
    public String name;
    public String group;
    public String password;

    public UserRegisterData() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ddHHmmss");
        LocalDateTime now = LocalDateTime.now();
        Random rand = new Random();
        this.email = "autogen" + rand.nextInt(99) + dtf.format(now)+"@email.com";
        this.name = "John Snow";
        this.password = TEST_PASSWORD;
        this.group = "ApiTest";
    }
}
