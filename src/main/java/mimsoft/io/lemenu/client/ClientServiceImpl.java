package mimsoft.io.lemenu.client;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public List<Client> getAll() {
        return clientRepository.findAllByDeletedFalse();
    }

    @Override
    public Client get(Long id) {
        Client client = clientRepository.findByIdAndByDeletedFalse(id);
        if (client==null)
            return null;
        return client;
    }

    @Override
    public Client getByPhone(String pone) {
        Client client =  clientRepository.findByPhone(pone);
        if (client==null)
            return null;
        return client;
    }

    @Override
    public boolean save(Client client) {
        clientRepository.save(client);
        return true;
    }

    @Override
    public boolean update(Client client) {
        if (clientRepository.findByIdAndByDeletedFalse(client.getId())!=null){
            clientRepository.save(client);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Long id) {
        Client client = clientRepository.findByIdAndByDeletedFalse(id);
        if (client!=null){
            clientRepository.delete(client);
            return true;
        }
        return false;
    }
}
