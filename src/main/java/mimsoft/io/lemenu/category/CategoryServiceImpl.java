package mimsoft.io.lemenu.category;

import mimsoft.io.lemenu.content.TextModel;
import org.springframework.stereotype.Service;

import java.util.List;
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
        return categoryRepository.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDto findById(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Category is not present"));
        return toDto(category);
    }

    @Override
    public boolean update(CategoryDto categoryDto) {
        categoryRepository.findById(categoryDto.getId()).orElseThrow(
                () -> new RuntimeException("Category not found"));
        categoryRepository.save(fromDto(categoryDto));
        return true;
    }

    @Override
    public boolean delete(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Category not found"));
        categoryRepository.delete(category);
        return true;
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
