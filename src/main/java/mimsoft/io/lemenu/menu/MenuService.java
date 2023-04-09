package mimsoft.io.lemenu.menu;

import java.util.List;

public interface MenuService {
    List<MenuDto> getAll();
    MenuDto getById(Long id);
    boolean save(MenuDto menuDto);
    boolean update(MenuDto menuDto);
    boolean delete(Long id);
}
