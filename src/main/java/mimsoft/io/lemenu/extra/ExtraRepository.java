package mimsoft.io.lemenu.extra;

import mimsoft.io.lemenu.branch.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ExtraRepository extends JpaRepository<Extra, Long> {
    List<Extra> findAllByDeletedFalse();

    @Query(value = "SELECT * FROM extra WHERE id = ?1 AND deleted = false", nativeQuery = true)
    Extra findByIdAndByDeletedFalse(Long id);
}
