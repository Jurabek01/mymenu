package mimsoft.io.lemenu.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mimsoft.io.lemenu.client.Client;
import mimsoft.io.lemenu.client.service.ClientService;
import mimsoft.io.lemenu.client.auth.JwtResponse;
import mimsoft.io.lemenu.security.props.JwtProperties;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Service
@RequiredArgsConstructor
@Slf4j
public class JwtTokenProvider {

    private final JwtProperties jwtProperties;

    private final UserDetailsService userDetailsService;
    private final ClientService clientService;

    private Key key;

    @PostConstruct
    public void init() {
        this.key = Keys.hmacShaKeyFor(jwtProperties.getSecret().getBytes());
    }

    public String createVerifyToken(Long deviceId, String sessionUuid) {
        Claims claims = Jwts.claims().setSubject(sessionUuid);
        claims.put("id", deviceId);
        Instant validity = Instant.now()
                .plus(jwtProperties.getAccess(), ChronoUnit.MINUTES);
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(Date.from(validity))
                .signWith(key)
                .compact();
    }

    public String createAccessToken(Long clientId, String phone) {
        Claims claims = Jwts.claims().setSubject(phone);
        claims.put("id", clientId);
        Instant validity = Instant.now()
                .plus(jwtProperties.getAccess(), ChronoUnit.HOURS);
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(Date.from(validity))
                .signWith(key)
                .compact();
    }

    public String createRefreshToken(Long clientId, String phone) {
        Claims claims = Jwts.claims().setSubject(phone);
        claims.put("id", clientId);
        Instant validity = Instant.now()
                .plus(jwtProperties.getRefresh(), ChronoUnit.DAYS);
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(Date.from(validity))
                .signWith(key)
                .compact();
    }

    public JwtResponse refreshClientTokens(String refreshToken) {
        JwtResponse jwtResponse = new JwtResponse();
        if (!validateToken(refreshToken)) {
            return null;
        }
        Long clientId = Long.valueOf(getId(refreshToken));
        Client client = clientService.get(clientId);
        jwtResponse.setId(clientId);
        jwtResponse.setPhone(client.getPhone());
        jwtResponse.setAccessToken(createAccessToken(clientId, client.getPhone()));
        jwtResponse.setRefreshToken(createRefreshToken(clientId, client.getPhone()));
        return jwtResponse;
    }

    public boolean validateToken(String token) {
        Jws<Claims> claims = Jwts
                .parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token);
        return !claims.getBody().getExpiration().before(new Date());
    }

    private String getId(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .get("id")
                .toString();
    }

    private String getPhone(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public Authentication getAuthentication(String token) {
        String phone = getPhone(token);
        UserDetails userDetails = userDetailsService.loadUserByUsername(phone);
        return new UsernamePasswordAuthenticationToken(userDetails, userDetails.getAuthorities());
    }
}
