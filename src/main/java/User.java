import lombok.Getter;
import lombok.Setter;

public class User {
    @Getter @Setter
    private String phone;
    @Getter @Setter
    private String password;

    public User(String phone, String password) {
        this.phone = phone;
        this.password = password;
    }
}
