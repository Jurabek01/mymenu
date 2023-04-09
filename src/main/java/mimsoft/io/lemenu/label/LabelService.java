package mimsoft.io.lemenu.label;

import java.util.List;
import java.util.Optional;

public interface LabelService {
    boolean save(Label label);
    List<Label> getAll();
    Optional<Label> findById(Long id);
    boolean update(Label label);
    boolean delete(Long id);
}
