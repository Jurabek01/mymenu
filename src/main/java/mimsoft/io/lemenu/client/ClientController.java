package mimsoft.io.lemenu.client;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1")
public class ClientController {

    private final ClientService clientService;
    private final ClientMapper clientMapper;

    public ClientController(ClientService clientService, ClientMapper clientMapper) {
        this.clientService = clientService;
        this.clientMapper = clientMapper;
    }

    @GetMapping("/clients")
    public ResponseEntity<List<ClientDto>> getAll() {
        return ResponseEntity.ok(clientService.getAll().stream()
                .map(clientMapper::toDto).collect(Collectors.toList()));
    }

    @GetMapping("/client/{id}")
    public ResponseEntity<ClientDto> get(@PathVariable Long id) {
        Client client = clientService.get(id);
        if (client == null)
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(clientMapper.toDto(client));
    }

    @PostMapping("/client")
    public ResponseEntity<Void> add(@RequestBody ClientDto clientDto) {
        clientService.save(clientMapper.toEntity(clientDto));
        return ResponseEntity.ok().build();
    }

    @PutMapping("/client")
    public ResponseEntity<Void> update(@RequestBody ClientDto clientDto) {
        if (clientService.update(clientMapper.toEntity(clientDto)))
            return ResponseEntity.ok().build();
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/client/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (clientService.delete(id))
            return ResponseEntity.ok().build();
        return ResponseEntity.noContent().build();
    }
}
