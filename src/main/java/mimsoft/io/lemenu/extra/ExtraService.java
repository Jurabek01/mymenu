package mimsoft.io.lemenu.extra;

import java.util.List;
import java.util.Optional;

public interface ExtraService {
    boolean save(ExtraDto extraDto);

    List<ExtraDto> getAll();

    ExtraDto findById(Long id);

    boolean update(ExtraDto extraDto);

    boolean delete(Long id);
}
