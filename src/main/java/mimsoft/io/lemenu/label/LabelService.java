package mimsoft.io.lemenu.label;

import java.util.List;

public interface LabelService {
    boolean save(LabelDto labelDto);
    List<LabelDto> getAll();
    LabelDto get(Long id);
    boolean update(LabelDto labelDto);
    boolean delete(Long id);
}
