package mimsoft.io.lemenu.category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    boolean save(CategoryDto categoryDto);
    List<CategoryDto> getAll();
    CategoryDto findById(Long id);
    boolean update(CategoryDto categoryDto);
    boolean delete(Long id);
}
