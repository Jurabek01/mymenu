package mimsoft.io.lemenu.menu;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class MenuController {
    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping("/menus")
    public ResponseEntity<List<MenuDto>> getAll() {
        return ResponseEntity.ok(menuService.getAll());
    }

    @GetMapping("/menu/{id}")
    public ResponseEntity<MenuDto> get(@PathVariable Long id) {
        MenuDto menuDto = menuService.get(id);
        if (menuDto == null)
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(menuDto);
    }

    @PostMapping("/menu")
    public ResponseEntity<Void> add(@RequestBody MenuDto menuDto) {
        menuService.save(menuDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/menu")
    public ResponseEntity<Void> update(@RequestBody MenuDto menuDto) {
        if (menuService.update(menuDto))
            return ResponseEntity.ok().build();
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/menu/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (menuService.delete(id))
            return ResponseEntity.ok().build();
        return ResponseEntity.noContent().build();
    }
}
