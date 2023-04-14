package mimsoft.io.lemenu.client;

import java.util.List;

public interface ClientService {
    List<ClientDto> getAll();
    ClientDto get(Long id);
    boolean save(ClientDto clientDto);
    boolean update(ClientDto clientDto);
    boolean delete(Long id);
}
