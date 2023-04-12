package mimsoft.io.lemenu.label;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class LabelController {

    private final LabelService labelService;

    public LabelController(LabelService labelService) {
        this.labelService = labelService;
    }

    @GetMapping("/labels")
    public ResponseEntity<List<LabelDto>> getAll() {
        return ResponseEntity.ok(labelService.getAll());
    }

    @GetMapping("/label/{id}")
    public ResponseEntity<LabelDto> get(@PathVariable Long id) {
        return ResponseEntity.ok(labelService.findById(id));
    }

    @PostMapping("/label")
    public ResponseEntity<Void> add(@RequestBody LabelDto labelDto) {
        labelService.save(labelDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/label")
    public ResponseEntity<Void> update(@RequestBody LabelDto labelDto) {
        labelService.update(labelDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/label/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        labelService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
