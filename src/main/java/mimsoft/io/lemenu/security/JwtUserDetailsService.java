package mimsoft.io.lemenu.security;

import lombok.RequiredArgsConstructor;
import mimsoft.io.lemenu.client.Client;
import mimsoft.io.lemenu.client.ClientService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@RequiredArgsConstructor
public class JwtUserDetailsService implements UserDetailsService {

    private final ClientService clientService;
    @Override
    public UserDetails loadUserByUsername(String phone) throws UsernameNotFoundException {
        Client client = clientService.getByPhone(phone);
        return JwtEntityFactory.create(client);
    }
}
