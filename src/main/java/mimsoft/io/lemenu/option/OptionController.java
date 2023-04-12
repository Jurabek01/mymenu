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
    public ResponseEntity<List<OptionDto>> getAll() {
        return ResponseEntity.ok(optionService.getAll());
    }

    @GetMapping("/option/{id}")
    public ResponseEntity<OptionDto> get(@PathVariable Long id) {
        OptionDto option = optionService.findById(id);
        return ResponseEntity.ok(option);
    }

    @PostMapping("/option")
    public ResponseEntity<Void> add(@RequestBody OptionDto optionDto) {
        optionService.save(optionDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/option/{id}")
    public ResponseEntity<Void> update(@RequestBody OptionDto optionDto) {
        optionService.update(optionDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/option/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        optionService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
