package mimsoft.io.lemenu.dish;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class DishController {

    private final DishService dishService;

    private final Logger logger = LoggerFactory.getLogger(DishController.class);

    JsonParser jsonParser = JsonParserFactory.getJsonParser();


    public DishController(DishService dishService) {
        this.dishService = dishService;
    }

    @GetMapping("/dishes")
    public ResponseEntity<List<DishDto>> getAll() {
        return ResponseEntity.ok(dishService.getAll());
    }

    @GetMapping("/dish/{id}")
    public ResponseEntity<Dish> get(@PathVariable Long id) {
        Optional<Dish> dish = dishService.findById(id);
        return dish.map(ResponseEntity::ok).orElseGet(() ->
                ResponseEntity.notFound().build());
    }

    @PostMapping("/dish")
    public ResponseEntity<Void> add(@RequestBody DishDto dishDto) {
        boolean addDish = dishService.save(dishDto);
        return ResponseEntity.ok().build();
    }

    @SneakyThrows
    @PutMapping("/dish/{id}")
    public ResponseEntity<Void> update(@RequestBody DishDto dishDto, @PathVariable Long id) {
        logger.info("dish dto1 -->" + new ObjectMapper().writeValueAsString(dishDto));
        dishService.update(dishDto, id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/dish/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        dishService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
