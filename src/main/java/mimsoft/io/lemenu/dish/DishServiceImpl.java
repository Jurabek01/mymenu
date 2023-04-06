package mimsoft.io.lemenu.dish;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class DishServiceImpl implements DishService {

    private final DishRepository dishRepository;

    private final Logger logger = LoggerFactory.getLogger(DishController.class);

    public DishServiceImpl(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    @Override
    @Transactional
    public boolean save(DishDto dishDto) {
        Dish dish = Dish.builder()
                .name(dishDto.getName())
                .menuId(dishDto.getMenuId())
                .image(dishDto.getImage())
                .description(dishDto.getDescription())
                .costPrice(dishDto.getCostPrice())
                .build();
        dishRepository.save(dish);
        return true;
    }

    @Override
    public List<DishDto> getAll() {
        return dishRepository.findAll().stream().map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Dish findByName(String name) {
        return dishRepository.findFirstByName(name);
    }

    @Override
    public Optional<Dish> findById(Long id) {
        return dishRepository.findById(id);
    }

    @SneakyThrows
    @Override
    @Transactional
    public boolean update(DishDto dishDto, Long id) {
        logger.info("dish dto2 -->" + new ObjectMapper().writeValueAsString(dishDto));
        Dish dish = dishRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Dish not found"));
        logger.info("dish dto3 -->" + new ObjectMapper().writeValueAsString(dishDto));
        dish = Dish.builder()
                .id(dish.getId())
                .menuId(dishDto.getMenuId())
                .costPrice(dishDto.getCostPrice())
                .description(dishDto.getDescription())
                .image(dishDto.getImage())
                .name(dishDto.getName())
                .build();
        dishRepository.save(dish);
        return true;
    }

    @Override
    public boolean delete(Long id) {
        Dish dish = dishRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Dish not found"));
        dishRepository.delete(dish);
        return true;
    }

    private DishDto toDto(Dish dish) {
        return DishDto.builder()
                .menuId(dish.getMenuId())
                .costPrice(dish.getCostPrice())
                .description(dish.getDescription())
                .image(dish.getImage())
                .name(dish.getName())
                .build();
    }
}
