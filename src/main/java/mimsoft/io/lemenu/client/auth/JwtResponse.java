package mimsoft.io.lemenu.client.auth;

import lombok.Data;

@Data
public class JwtResponse {
    private Long id;
    private String phone;
    private String accessToken;
    private String refreshToken;
}
