package mimsoft.io.lemenu.extra;

import jakarta.transaction.Transactional;
import mimsoft.io.lemenu.content.TextModel;
import mimsoft.io.lemenu.product.ProductController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
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
        return extraRepository.findAllByDeletedFalse().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ExtraDto get(Long id) {
        Extra extra = extraRepository.findByIdAndByDeletedFalse(id);
        if (extra==null)
            return null;
        return toDto(extra);
    }

    @Override
    @Transactional
    public boolean update(ExtraDto extraDto) {
        if (extraRepository.findByIdAndByDeletedFalse(extraDto.getId())!=null) {
            extraRepository.save(fromDto(extraDto));
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Long id) {
        Extra extra = extraRepository.findByIdAndByDeletedFalse(id);
        if (extra!=null) {
            extra.setDeleted(true);
            extraRepository.save(extra);
            return true;
        }
        return false;
    }

    private Extra fromDto(ExtraDto extraDto) {
        return Extra.builder()
                .id(extraDto.getId())
                .nameUz(extraDto.getName().getUz())
                .nameRu(extraDto.getName().getRu())
                .nameEng(extraDto.getName().getEng())
                .price(extraDto.getPrice())
                .descriptionUz(extraDto.getDescription().getUz())
                .descriptionRu(extraDto.getDescription().getRu())
                .descriptionEng(extraDto.getDescription().getEng())
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
                .description(
                        new TextModel(
                                extra.getDescriptionUz(),
                                extra.getDescriptionRu(),
                                extra.getDescriptionEng()
                        )
                )
                .build();
    }

}
