package mimsoft.io.lemenu.client.auth;

public interface AuthService {

    JwtResponse sendCode(JwtRequest jwtRequest);

    JwtResponse refresh(String refreshToken);
}
