package mimsoft.io.lemenu.extra;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import lombok.SneakyThrows;
import mimsoft.io.lemenu.dish.DishController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ExtraServiceImpl implements ExtraService {
    private final ExtraRepository extraRepository;

    private final Logger logger = LoggerFactory.getLogger(DishController.class);

    public ExtraServiceImpl(ExtraRepository extraRepository) {
        this.extraRepository = extraRepository;
    }

    @Override
    @Transactional
    public boolean save(ExtraDto extraDto) {
        Extra extra = Extra.builder()
                .name(extraDto.getName())
                .price(extraDto.getPrice())
                .description(extraDto.getDescription())
                .option(extraDto.getOption())
                .build();
        extraRepository.save(extra);
        return true;
    }

    @Override
    public List<ExtraDto> getAll() {
        return extraRepository.findAll().stream().map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Extra findByName(String name) {
        return extraRepository.findFirstByName(name);
    }

    @Override
    public Optional<Extra> findById(Long id) {
        return extraRepository.findById(id);
    }

    @SneakyThrows
    @Override
    @Transactional
    public boolean update(ExtraDto extraDto, Long id) {
        logger.info("extra dto2 -->" + new ObjectMapper().writeValueAsString(extraDto));
        Extra extra = extraRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Dish not found"));
        logger.info("extra dto3 -->" + new ObjectMapper().writeValueAsString(extraDto));
        extra = Extra.builder()
                .id(extra.getId())
                .price(extraDto.getPrice())
                .description(extraDto.getDescription())
                .name(extraDto.getName())
                .build();
        extraRepository.save(extra);
        return true;
    }

    @Override
    public boolean delete(Long id) {
        Extra extra = extraRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Dish not found"));
        extraRepository.delete(extra);
        return true;
    }

    private ExtraDto toDto(Extra extra) {
        return ExtraDto.builder()
                .name(extra.getName())
                .price(extra.getPrice())
                .description(extra.getDescription())
                .option(extra.getOption())
                .build();
    }
}
