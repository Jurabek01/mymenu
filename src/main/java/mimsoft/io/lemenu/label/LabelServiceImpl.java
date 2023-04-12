package mimsoft.io.lemenu.label;

import jakarta.transaction.Transactional;
import mimsoft.io.lemenu.content.TextModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LabelServiceImpl implements LabelService {

    private final LabelRepository labelRepository;

    public LabelServiceImpl(LabelRepository labelRepository) {
        this.labelRepository = labelRepository;
    }

    @Override
    @Transactional
    public boolean save(LabelDto labelDto) {
        labelRepository.save(fromDto(labelDto));
        return true;
    }

    @Override
    public List<LabelDto> getAll() {
        return labelRepository.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public LabelDto findById(Long id) {
        Label label = labelRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Label not found"));
        return toDto(label);
    }

    @Override
    public boolean update(LabelDto labelDto) {
        labelRepository.findById(labelDto.getId())
                .orElseThrow(() -> new RuntimeException("Label not found"));
        labelRepository.save(fromDto(labelDto));
        return true;
    }

    @Override
    public boolean delete(Long id) {
        Label label = labelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Label not found"));
        labelRepository.delete(label);
        return false;
    }

    private Label fromDto(LabelDto labelDto) {
        return Label.builder()
                .id(labelDto.getId())
                .menuId(labelDto.getMenuId())
                .nameUz(labelDto.getName().getUz())
                .nameRu(labelDto.getName().getRu())
                .nameEng(labelDto.getName().getEng())
                .icon(labelDto.getIcon())
                .textColor(labelDto.getTextColor())
                .bgColor(labelDto.getBgColor())
                .build();
    }

    private LabelDto toDto(Label label) {
        return LabelDto.builder()
                .id(label.getId())
                .menuId(label.getMenuId())
                .name(
                        new TextModel(
                                label.getNameUz(),
                                label.getNameRu(),
                                label.getNameEng()
                        )
                )
                .icon(label.getIcon())
                .bgColor(label.getBgColor())
                .textColor(label.getTextColor())
                .build();
    }
}
