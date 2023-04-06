package mimsoft.io.lemenu.extra;

import mimsoft.io.lemenu.dish.Dish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExtraRepository extends JpaRepository<Extra, Long> {
    Extra findFirstByName(String name);
}
