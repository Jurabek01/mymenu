package mimsoft.io.lemenu.category;

import java.util.List;

public interface CategoryService {
    boolean save(CategoryDto categoryDto);
    List<CategoryDto> getAll();
    CategoryDto get(Long id);
    boolean update(CategoryDto categoryDto);
    boolean delete(Long id);
}
