package mimsoft.io.lemenu.extra;

import mimsoft.io.lemenu.dish.Dish;
import mimsoft.io.lemenu.dish.DishDto;

import java.util.List;
import java.util.Optional;

public interface ExtraService {
    boolean save(ExtraDto extraDto);

    List<ExtraDto> getAll();

    Extra findByName(String name);

    Optional<Extra> findById(Long id);

    boolean update(ExtraDto extraDto, Long id);

    boolean delete(Long id);
}
