package mimsoft.io.lemenu.category;

import mimsoft.io.lemenu.content.TextModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public boolean save(CategoryDto categoryDto) {
        categoryRepository.save(fromDto(categoryDto));
        return true;
    }

    @Override
    public List<CategoryDto> getAll() {
        return categoryRepository.findAllByDeletedFalse().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDto get(Long id) {
        Category category = categoryRepository.findByIdAndByDeletedFalse(id);
        if (category == null)
            return null;
        return toDto(category);
    }

    @Override
    public boolean update(CategoryDto categoryDto) {
        if (categoryRepository.findByIdAndByDeletedFalse(categoryDto.getId())!=null) {
            categoryRepository.save(fromDto(categoryDto));
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Long id) {
        Category category = categoryRepository.findByIdAndByDeletedFalse(id);
        if (category!=null){
            category.setDeleted(true);
            categoryRepository.save(category);
            return true;
        }
        return false;
    }

    private CategoryDto toDto(Category category) {
        return CategoryDto.builder()
                .id(category.getId())
                .name(
                        new TextModel(
                                category.getNameUz(),
                                category.getNameRu(),
                                category.getNameEng()
                        )
                )
                .image(category.getImage())
                .build();
    }

    private Category fromDto(CategoryDto categoryDto) {
        return Category.builder()
                .id(categoryDto.getId())
                .nameEng(categoryDto.getName().getEng())
                .nameUz(categoryDto.getName().getUz())
                .nameRu(categoryDto.getName().getRu())
                .image(categoryDto.getImage())
                .build();
    }
}
