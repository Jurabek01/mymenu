package mimsoft.io.lemenu.client.mapper;


import mimsoft.io.lemenu.client.Client;
import mimsoft.io.lemenu.client.ClientDto;

public interface ClientMapper {
    Client toEntity(ClientDto dto);

    ClientDto toDto(Client entity);

}