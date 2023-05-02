package mimsoft.io.lemenu.client;


public interface ClientMapper {
    Client toEntity(ClientDto dto);

    ClientDto toDto(Client entity);

}