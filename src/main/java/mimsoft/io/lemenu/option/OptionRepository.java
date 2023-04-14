package mimsoft.io.lemenu.option;

import mimsoft.io.lemenu.branch.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OptionRepository extends JpaRepository<Option, Long> {
    List<Option> findAllByDeletedFalse();

    @Query(value = "SELECT * FROM option WHERE id = ?1 AND deleted = false", nativeQuery = true)
    Option findByIdAndByDeletedFalse(Long id);
}
