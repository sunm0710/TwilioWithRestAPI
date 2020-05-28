import com.google.gson.JsonElement;
import lombok.Getter;
import lombok.Setter;

public class Response {
    @Getter
    @Setter
    private String message;
    public Response(String m) {
        this.message = m;
    }
}
