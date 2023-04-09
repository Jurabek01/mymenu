package mimsoft.io.lemenu.category;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/categories")
    public ResponseEntity<List<CategoryDto>> getAll() {
        return ResponseEntity.ok(categoryService.getAll());
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<CategoryDto> get(@PathVariable Long id) {
        return ResponseEntity.ok(categoryService.findById(id));
    }

    @PostMapping("/category")
    public ResponseEntity<Void> add(@RequestBody CategoryDto categoryDto) {
        categoryService.save(categoryDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/category")
    public ResponseEntity<Void> update(@RequestBody CategoryDto categoryDto) {
        categoryService.update(categoryDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/category")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        categoryService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
