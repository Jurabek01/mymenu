package mimsoft.io.lemenu.client;

import jakarta.validation.constraints.PastOrPresent;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/clients")
    public ResponseEntity<List<ClientDto>> getAll() {
        return ResponseEntity.ok(clientService.getAll());
    }

    @GetMapping("/client/{id}")
    public ResponseEntity<ClientDto> get(@PathVariable Long id) {
        ClientDto clientDto = clientService.get(id);
        if (clientDto == null)
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(clientDto);
    }

    @PostMapping("/client")
    public ResponseEntity<Void> add(@RequestBody ClientDto clientDto) {
        clientService.save(clientDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/client")
    public ResponseEntity<Void> update(@RequestBody ClientDto clientDto) {
        if (clientService.update(clientDto))
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
