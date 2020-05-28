public interface AuthService {
    void addUser(User user);
    boolean authUser(String phone, String password);
}
