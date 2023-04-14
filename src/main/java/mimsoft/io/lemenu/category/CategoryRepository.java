package mimsoft.io.lemenu.category;

import mimsoft.io.lemenu.branch.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findAllByDeletedFalse();

    @Query(value = "SELECT * FROM category WHERE id = ?1 AND deleted = false", nativeQuery = true)
    Category findByIdAndByDeletedFalse(Long id);
}
