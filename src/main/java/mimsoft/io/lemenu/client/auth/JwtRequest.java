package mimsoft.io.lemenu.client.auth;

import lombok.Data;

@Data
public class JwtRequest {
    private String phone;
    private Long confirmCode;
}
