package mimsoft.io.lemenu.client.mapper;

import mimsoft.io.lemenu.client.Client;
import mimsoft.io.lemenu.client.ClientDto;
import mimsoft.io.lemenu.client.mapper.ClientMapper;
import org.springframework.stereotype.Service;

@Service
public class ClientMapperImpl implements ClientMapper {
    @Override
    public Client toEntity(ClientDto clientDto) {
        return Client.builder()
                .id(clientDto.getId())
                .phone(clientDto.getPhone())
                .firstName(clientDto.getFirstName())
                .lastName(clientDto.getLastName())
                .birthDay(clientDto.getBirthDay())
                .image(clientDto.getImage())
                .build();
    }

    @Override
    public ClientDto toDto(Client client) {
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
