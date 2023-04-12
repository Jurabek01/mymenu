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
public class OptionServiceImpl implements OptionService{

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
        return optionRepository.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public OptionDto findById(Long id) {
        Option option = optionRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Option not found"));
        return toDto(option);
    }

    @Override
    public boolean update(OptionDto optionDto) {
        optionRepository.findById(optionDto.getId())
                .orElseThrow(() -> new RuntimeException("Option not found"));
        optionRepository.save(fromDto(optionDto));
        return true;
    }

    @Override
    public boolean delete(Long id) {
        Option option = optionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Option not found"));
        optionRepository.delete(option);
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
                .description(optionDto.getDescription())
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
                .description(option.getDescription())
                .build();
    }

}
