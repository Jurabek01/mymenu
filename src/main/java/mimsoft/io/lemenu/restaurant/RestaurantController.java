package mimsoft.io.lemenu.restaurant;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class RestaurantController {
    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }
    @GetMapping("/restaurants")
    public ResponseEntity<List<RestaurantDto>> getAll() {
        return ResponseEntity.ok(restaurantService.getAll());
    }
    @GetMapping("/restaurant/{id}")
    public ResponseEntity<RestaurantDto> get(@PathVariable Long id) {
        return ResponseEntity.ok(restaurantService.get(id));
    }
    @PostMapping("/restaurant")
    public ResponseEntity<Void> add(@RequestBody RestaurantDto restaurantDto) {
        restaurantService.save(restaurantDto);
        return ResponseEntity.ok().build();
    }
    @PutMapping("/restaurant")
    public ResponseEntity<Void> update(@RequestBody RestaurantDto restaurantDto) {
        restaurantService.update(restaurantDto);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/restaurant/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        restaurantService.delete(id);
        return ResponseEntity.ok().build();
    }
}
