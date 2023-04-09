package mimsoft.io.lemenu.option;

import java.util.List;
import java.util.Optional;

public interface OptionService {

    boolean save(Option option);

    List<Option> getAll();

    Optional<Option> findById(Long id);

    boolean update(Option option);

    boolean delete(Long id);
}
