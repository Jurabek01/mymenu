package mimsoft.io.lemenu.extra;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ExtraController {

    private final ExtraService extraService;

    public ExtraController(ExtraService extraService) {
        this.extraService = extraService;
    }

    @GetMapping("/extras")
    public ResponseEntity<List<ExtraDto>> getAll() {
        return ResponseEntity.ok(extraService.getAll());
    }

    @GetMapping("/extra/{id}")
    public ResponseEntity<ExtraDto> get(@PathVariable Long id) {
        return ResponseEntity.ok(extraService.findById(id));
    }

    @PostMapping("/extra")
    public ResponseEntity<Void> add(@RequestBody ExtraDto extraDto) {
        extraService.save(extraDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/extra")
    public ResponseEntity<Void> update(@RequestBody ExtraDto extraDto) {
        extraService.update(extraDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/extra")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        extraService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
