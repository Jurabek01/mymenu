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
    public ResponseEntity<List<Label>> getAll() {
        return ResponseEntity.ok(labelService.getAll());
    }

    @GetMapping("/label/{id}")
    public ResponseEntity<Label> get(@PathVariable Long id) {
        Optional<Label> label = labelService.findById(id);
        return label.map(ResponseEntity::ok).orElseGet(() ->
                ResponseEntity.notFound().build());
    }

    @PostMapping("/label")
    public ResponseEntity<Void> add(@RequestBody Label label) {
        labelService.save(label);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/label")
    public ResponseEntity<Void> update(@RequestBody Label label) {
        labelService.update(label);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/label/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        labelService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
