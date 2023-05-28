package mimsoft.io.lemenu.security;

import mimsoft.io.lemenu.client.Client;

public class JwtEntityFactory {

    public static LaEntity create(Client client) {
        return new LaEntity(
                client.getId(),
                client.getPhone(),
                client.getFirstName(),
                client.getLastName()
        );
    }
}
