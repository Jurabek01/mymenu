package mimsoft.io.lemenu.label;

import java.util.List;
import java.util.Optional;

public interface LabelService {
    boolean save(LabelDto labelDto);
    List<LabelDto> getAll();
    LabelDto findById(Long id);
    boolean update(LabelDto labelDto);
    boolean delete(Long id);
}
