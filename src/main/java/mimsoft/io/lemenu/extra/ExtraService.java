package mimsoft.io.lemenu.extra;

import java.util.List;

public interface ExtraService {
    boolean save(ExtraDto extraDto);

    List<ExtraDto> getAll();

    ExtraDto get(Long id);

    boolean update(ExtraDto extraDto);

    boolean delete(Long id);
}
