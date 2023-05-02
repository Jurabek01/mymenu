package mimsoft.io.lemenu.client;

import java.util.List;

public interface ClientService {
    List<Client> getAll();
    Client get(Long id);

    Client getByPhone(String phone);
    boolean save(Client client);
    boolean update(Client client);
    boolean delete(Long id);
}
