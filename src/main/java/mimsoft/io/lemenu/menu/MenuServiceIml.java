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
        return menuRepository.findAllByDeletedFalse().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public MenuDto get(Long id) {
        Menu menu = menuRepository.findByIdAndByDeletedFalse(id);
        if (menu==null)
            return null;
        return toDto(menu);
    }

    @Override
    public boolean save(MenuDto menuDto) {
        menuRepository.save(fromDto(menuDto));
        return true;
    }

    @Override
    public boolean update(MenuDto menuDto) {
        if (menuRepository.findByIdAndByDeletedFalse(menuDto.getId())!=null) {
            menuRepository.save(fromDto(menuDto));
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Long id) {
        Menu menu = menuRepository.findByIdAndByDeletedFalse(id);
        if (menu!=null){
            menu.setDeleted(true);
            menuRepository.save(menu);
            return true;
        }
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

    private Menu fromDto(MenuDto menuDto) {
        return Menu.builder()
                .id(menuDto.getId())
                .nameUz(menuDto.getName().getUz())
                .nameRu(menuDto.getName().getRu())
                .nameEng(menuDto.getName().getEng())
                .build();
    }
}
