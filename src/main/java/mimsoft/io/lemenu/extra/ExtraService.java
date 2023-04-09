package mimsoft.io.lemenu.extra;

import java.util.List;
import java.util.Optional;

public interface ExtraService {
    boolean save(Extra extra);

    List<Extra> getAll();

    Optional<Extra> findById(Long id);

    boolean update(Extra extra);

    boolean delete(Long id);
}
