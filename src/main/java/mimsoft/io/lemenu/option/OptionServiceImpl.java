package mimsoft.io.lemenu.option;

import mimsoft.io.lemenu.content.TextModel;
import mimsoft.io.lemenu.product.ProductService;
import mimsoft.io.lemenu.product.productToOption.PtoService;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OptionServiceImpl implements OptionService {

    private final OptionRepository optionRepository;

    public OptionServiceImpl(OptionRepository optionRepository) {
        this.optionRepository = optionRepository;
    }

    @Override
    @Transactional
    public boolean save(OptionDto optionDto) {
        optionRepository.save(fromDto(optionDto));
        return true;
    }

    @Override
    public List<OptionDto> getAll() {
        return optionRepository.findAllByDeletedFalse().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public OptionDto get(Long id) {
        Option option = optionRepository.findByIdAndByDeletedFalse(id);
        if (option==null)
            return null;
        return toDto(option);
    }

    @Override
    public boolean update(OptionDto optionDto) {
        if (optionRepository.findByIdAndByDeletedFalse(optionDto.getId())!=null) {
            optionRepository.save(fromDto(optionDto));
            return true;
        } else return false;
    }

    @Override
    public boolean delete(Long id) {
        Option option = optionRepository.findByIdAndByDeletedFalse(id);
        if (option!=null) {
            option.setDeleted(true);
            optionRepository.delete(option);
            return true;
        } else
            return false;
    }

    private Option fromDto(OptionDto optionDto) {
        return Option.builder()
                .id(optionDto.getId())
                .nameUz(optionDto.getName().getUz())
                .nameRu(optionDto.getName().getRu())
                .nameEng(optionDto.getName().getEng())
                .image(optionDto.getImage())
                .price(optionDto.getPrice())
                .descriptionUz(optionDto.getDescription().getUz())
                .descriptionRu(optionDto.getDescription().getRu())
                .descriptionEng(optionDto.getDescription().getEng())
                .build();
    }

    private OptionDto toDto(Option option) {
        return OptionDto.builder()
                .id(option.getId())
                .name(
                        new TextModel(
                                option.getNameUz(),
                                option.getNameRu(),
                                option.getNameEng()
                        )
                )
                .image(option.getImage())
                .price(option.getPrice())
                .description(
                        new TextModel(
                                option.getDescriptionUz(),
                                option.getDescriptionRu(),
                                option.getDescriptionEng()
                        )
                )
                .build();
    }

}
