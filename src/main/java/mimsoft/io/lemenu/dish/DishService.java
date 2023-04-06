package mimsoft.io.lemenu.dish;

import java.util.List;
import java.util.Optional;

public interface DishService {
    boolean save(DishDto dishDto);

    List<DishDto> getAll();

    Dish findByName(String name);

    Optional<Dish> findById(Long id);

    boolean update(DishDto dishDto, Long id);

    boolean delete(Long id);
}
