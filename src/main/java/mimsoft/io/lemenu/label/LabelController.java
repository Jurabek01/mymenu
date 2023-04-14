package mimsoft.io.lemenu.label;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        LabelDto labelDto = labelService.get(id);
        if (labelDto == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(labelDto);
    }

    @PostMapping("/label")
    public ResponseEntity<Void> add(@RequestBody LabelDto labelDto) {
        labelService.save(labelDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/label")
    public ResponseEntity<Void> update(@RequestBody LabelDto labelDto) {
        if (labelService.update(labelDto))
            return ResponseEntity.ok().build();
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/label/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (labelService.delete(id))
            ResponseEntity.ok().build();
        return ResponseEntity.noContent().build();
    }
}
