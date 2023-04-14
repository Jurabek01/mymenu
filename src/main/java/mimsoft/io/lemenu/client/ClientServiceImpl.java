package mimsoft.io.lemenu.client;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public List<ClientDto> getAll() {
        return clientRepository.findAllByDeletedFalse().stream()
                .map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public ClientDto get(Long id) {
        Client client = clientRepository.findByIdAndByDeletedFalse(id);
        if (client==null)
            return null;
        return toDto(client);
    }

    @Override
    public boolean save(ClientDto clientDto) {
        clientRepository.save(fromDto(clientDto));
        return true;
    }

    @Override
    public boolean update(ClientDto clientDto) {
        if (clientRepository.findByIdAndByDeletedFalse(clientDto.getId())!=null){
            clientRepository.save(fromDto(clientDto));
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

    private Client fromDto(ClientDto clientDto) {
        return Client.builder()
                .id(clientDto.getId())
                .phone(clientDto.getPhone())
                .firstName(clientDto.getFirstName())
                .lastName(clientDto.getLastName())
                .birthDay(clientDto.getBirthDay())
                .image(clientDto.getImage())
                .build();
    }

    private ClientDto toDto(Client client) {
        return ClientDto.builder()
                .id(client.getId())
                .phone(client.getPhone())
                .firstName(client.getFirstName())
                .lastName(client.getLastName())
                .birthDay(client.getBirthDay())
                .image(client.getImage())
                .build();
    }
}
