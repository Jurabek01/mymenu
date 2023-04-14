package mimsoft.io.lemenu.branch;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class BranchController {
    private final BranchService branchService;

    public BranchController(BranchService branchService) {
        this.branchService = branchService;
    }

    @GetMapping("/branches")
    public ResponseEntity<List<BranchDto>> getAll() {
        return ResponseEntity.ok(branchService.getAll());
    }

    @GetMapping("/branch/{id}")
    public ResponseEntity<BranchDto> get(@PathVariable Long id) {
        BranchDto branchDto = branchService.get(id);
        if (branchDto == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(branchDto);
    }

    @PostMapping("/branch")
    public ResponseEntity<Void> add(@RequestBody BranchDto branchDto) {
        branchService.save(branchDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/branch")
    public ResponseEntity<Void> update(@RequestBody BranchDto branchDto) {
        boolean status = branchService.update(branchDto);
        if (status) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/branch/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (branchService.delete(id))
            return ResponseEntity.ok().build();
        return ResponseEntity.noContent().build();
    }
}
