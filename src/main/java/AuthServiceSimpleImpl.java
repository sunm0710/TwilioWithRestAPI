import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

public class AuthServiceSimpleImpl implements AuthService {
    final static Logger logger = LoggerFactory.getLogger(AuthServiceSimpleImpl.class);
    private HashMap<String, User> userMap;
    public AuthServiceSimpleImpl() {
        userMap = new HashMap<String, User>();
    }


    public void addUser(User user) {
        userMap.put(user.getPhone(), user);
        logger.info("Add user with phone number {}", user.getPhone());
    }

    public boolean authUser(String phone, String password) {
        if (userMap.containsKey(phone)) {
            String correctPassword = userMap.get(phone).getPassword();
            if (correctPassword.equals(password)) {
                return true;
            }
        }
        return false;
    }
}
