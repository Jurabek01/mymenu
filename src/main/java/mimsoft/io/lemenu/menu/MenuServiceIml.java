package mimsoft.io.lemenu.menu;

import mimsoft.io.lemenu.content.TextModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MenuServiceIml implements MenuService {
    private final MenuRepository menuRepository;

    public MenuServiceIml(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    @Override
    public List<MenuDto> getAll() {
        return menuRepository.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public MenuDto getById(Long id) {
        Menu menu = menuRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Menu is not present"));
        return toDto(menu);
    }

    @Override
    public boolean save(MenuDto menuDto) {
        menuRepository.save(dtoTo(menuDto));
        return true;
    }

    @Override
    public boolean update(MenuDto menuDto) {
        menuRepository.findById(menuDto.getId()).orElseThrow(
                () -> new RuntimeException("Menu not found"));
        menuRepository.save(dtoTo(menuDto));
        return true;
    }

    @Override
    public boolean delete(Long id) {
        Menu menu = menuRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Menu not found"));
        menuRepository.delete(menu);
        return false;
    }

    private MenuDto toDto(Menu menu) {
        return MenuDto.builder()
                .id(menu.getId())
                .name(
                        new TextModel(
                                menu.getNameUz(),
                                menu.getNameRu(),
                                menu.getNameEng()
                        )
                )
                .build();
    }

    private Menu dtoTo(MenuDto menuDto) {
        return Menu.builder()
                .id(menuDto.getId())
                .nameUz(menuDto.getName().getUz())
                .nameRu(menuDto.getName().getRu())
                .nameEng(menuDto.getName().getEng())
                .build();
    }
}
