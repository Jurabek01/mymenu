package mimsoft.io.lemenu.branch;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BranchRepository extends JpaRepository<Branch, Long> {
    List<Branch> findAllByDeletedFalse();

    @Query(value = "SELECT * FROM branch WHERE id = ?1 AND deleted = false", nativeQuery = true)
    Branch findByIdAndByDeletedFalse(Long id);
}
