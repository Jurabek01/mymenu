package mimsoft.io.lemenu.option;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class OptionController {

    private final OptionService optionService;

    public OptionController(OptionService optionService) {
        this.optionService = optionService;
    }

    @GetMapping("/options")
    public ResponseEntity<List<Option>> getAll() {
        return ResponseEntity.ok(optionService.getAll());
    }

    @GetMapping("/option/{id}")
    public ResponseEntity<Option> get(@PathVariable Long id) {
        Optional<Option> option = optionService.findById(id);
        return option.map(ResponseEntity::ok).orElseGet(() ->
                ResponseEntity.notFound().build());
    }

    @PostMapping("/option")
    public ResponseEntity<Void> add(@RequestBody Option option) {
        optionService.save(option);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/option/{id}")
    public ResponseEntity<Void> update(@RequestBody Option option) {
        optionService.update(option);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/option/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        optionService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
