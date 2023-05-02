package mimsoft.io.lemenu.security;

import mimsoft.io.lemenu.client.Client;

public class JwtEntityFactory {

    public static JwtEntity create(Client client) {
        return new JwtEntity(
                client.getId(),
                client.getPhone(),
                client.getFirstName(),
                client.getLastName()
        );
    }
}
