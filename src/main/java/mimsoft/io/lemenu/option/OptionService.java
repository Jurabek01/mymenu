package mimsoft.io.lemenu.option;

import java.util.List;

public interface OptionService {

    boolean save(OptionDto optionDto);

    List<OptionDto> getAll();

    OptionDto get(Long id);

    boolean update(OptionDto optionDto);

    boolean delete(Long id);
}
