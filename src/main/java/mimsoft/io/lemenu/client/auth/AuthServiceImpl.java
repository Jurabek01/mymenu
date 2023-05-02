package mimsoft.io.lemenu.client.auth;

import lombok.RequiredArgsConstructor;
import mimsoft.io.lemenu.client.ClientService;
import mimsoft.io.lemenu.security.JwtTokenProvider;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final ClientService clientService;
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public JwtResponse sendCode(JwtRequest jwtRequest) {
        JwtResponse jwtResponse = new JwtResponse();

        return null;
    }

    @Override
    public JwtResponse refresh(String refreshToken) {
        return null;
    }
}
