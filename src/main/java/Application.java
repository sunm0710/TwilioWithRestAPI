import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static spark.Spark.get;
import static spark.Spark.post;

public class Application {
    public static void main(String[] args) {
        final Logger logger = LoggerFactory.getLogger(Application.class);
        // define a simple Rest API here
        // default port number for spark-java is 4567
        final AuthService authService = new AuthServiceSimpleImpl();

        // user related
        get("/register", (req, res) -> {
            res.type("application/json");
            User user = new User(
                    req.queryParams("phone"),
                    req.queryParams("password"));
            logger.info(req.queryParams("nickname"));
            logger.info(req.queryParams("phone"));
            authService.addUser(user);
            return new Gson().toJson(new Response("Successfully registered."));
        });

        get("/auth", (req, res) -> {
            res.type("application/json");
            String phone = req.queryParams("phone");
            String password = req.queryParams("password");
            if (authService.authUser(phone, password)) {
                return new Gson().toJson(new Response("Successfully authenticated."));
            } else {
                return new Gson().toJson(new Response("Authentication failed."));
            }
        });

    }
}
