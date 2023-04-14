package mimsoft.io.lemenu.category;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        CategoryDto categoryDto = categoryService.get(id);
        if (categoryDto == null)
            ResponseEntity.noContent().build();
        return ResponseEntity.ok(categoryDto);
    }

    @PostMapping("/category")
    public ResponseEntity<Void> add(@RequestBody CategoryDto categoryDto) {
        categoryService.save(categoryDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/category")
    public ResponseEntity<Void> update(@RequestBody CategoryDto categoryDto) {
        if (categoryService.update(categoryDto))
            return ResponseEntity.ok().build();
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/category/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (categoryService.delete(id))
            return ResponseEntity.ok().build();
        return ResponseEntity.noContent().build();
    }
}
