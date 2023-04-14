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
        ExtraDto extraDto = extraService.get(id);
        if (extraDto == null)
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(extraDto);
    }

    @PostMapping("/extra")
    public ResponseEntity<Void> add(@RequestBody ExtraDto extraDto) {
        extraService.save(extraDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/extra")
    public ResponseEntity<Void> update(@RequestBody ExtraDto extraDto) {
        if (extraService.update(extraDto))
            return ResponseEntity.ok().build();
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/extra/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (extraService.delete(id))
            return ResponseEntity.ok().build();
        return ResponseEntity.noContent().build();
    }
}
