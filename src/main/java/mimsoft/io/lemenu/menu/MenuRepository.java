package mimsoft.io.lemenu.menu;

import mimsoft.io.lemenu.branch.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, Long> {
    List<Menu> findAllByDeletedFalse();

    @Query(value = "SELECT * FROM branch WHERE id = ?1 AND deleted = false", nativeQuery = true)
    Menu findByIdAndByDeletedFalse(Long id);
}
