package mimsoft.io.lemenu.label;

import jakarta.transaction.Transactional;
import mimsoft.io.lemenu.content.TextModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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
        return labelRepository.findAllByDeletedFalse().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public LabelDto get(Long id) {
        Label label = labelRepository.findByIdAndByDeletedFalse(id);
        if (label==null)
            return null;
        return toDto(label);
    }

    @Override
    public boolean update(LabelDto labelDto) {
        if (labelRepository.findByIdAndByDeletedFalse(labelDto.getId())!=null) {
            labelRepository.save(fromDto(labelDto));
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Long id) {
        Label label = labelRepository.findByIdAndByDeletedFalse(id);
        if (label!=null) {
            label.setDeleted(true);
            labelRepository.save(label);
            return true;
        }
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
