package mimsoft.io.lemenu.extra;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import lombok.SneakyThrows;
import mimsoft.io.lemenu.content.TextModel;
import mimsoft.io.lemenu.product.ProductController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ExtraServiceImpl implements ExtraService {
    private final ExtraRepository extraRepository;

    private final Logger logger = LoggerFactory.getLogger(ProductController.class);

    public ExtraServiceImpl(ExtraRepository extraRepository) {
        this.extraRepository = extraRepository;
    }

    @Override
    @Transactional
    public boolean save(ExtraDto extraDto) {
        extraRepository.save(fromDto(extraDto));
        return true;
    }

    @Override
    public List<ExtraDto> getAll() {
        return extraRepository.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ExtraDto findById(Long id) {
        Extra extra = extraRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Label not found"));
        return toDto(extra);
    }

    @Override
    @Transactional
    public boolean update(ExtraDto extraDto) {
        extraRepository.findById(extraDto.getId())
                .orElseThrow(() -> new RuntimeException("Product not found"));
        extraRepository.save(fromDto(extraDto));
        return true;
    }

    @Override
    public boolean delete(Long id) {
        Extra extra = extraRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        extraRepository.delete(extra);
        return true;
    }

    private Extra fromDto(ExtraDto extraDto) {
        return Extra.builder()
                .id(extraDto.getId())
                .nameUz(extraDto.getName().getUz())
                .nameRu(extraDto.getName().getRu())
                .nameEng(extraDto.getName().getEng())
                .price(extraDto.getPrice())
                .description(extraDto.getDescription())
                .build();
    }

    private ExtraDto toDto(Extra extra) {
        return ExtraDto.builder()
                .id(extra.getId())
                .name(
                        new TextModel(
                                extra.getNameUz(),
                                extra.getNameRu(),
                                extra.getNameEng()
                        )
                )
                .price(extra.getPrice())
                .description(extra.getDescription())
                .build();
    }

}
