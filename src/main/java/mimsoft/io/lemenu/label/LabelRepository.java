package mimsoft.io.lemenu.label;

import mimsoft.io.lemenu.branch.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LabelRepository extends JpaRepository<Label, Long> {
    List<Label> findAllByDeletedFalse();

    @Query(value = "SELECT * FROM label WHERE id = ?1 AND deleted = false", nativeQuery = true)
    Label findByIdAndByDeletedFalse(Long id);
}
