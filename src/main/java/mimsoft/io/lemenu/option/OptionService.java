package mimsoft.io.lemenu.option;

import java.util.List;
import java.util.Optional;

public interface OptionService {

    boolean save(OptionDto optionDto);

    List<OptionDto> getAll();

    OptionDto findById(Long id);

    boolean update(OptionDto optionDto);

    boolean delete(Long id);
}
