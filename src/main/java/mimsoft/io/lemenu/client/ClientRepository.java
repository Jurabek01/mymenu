package mimsoft.io.lemenu.client;

import mimsoft.io.lemenu.branch.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {
    List<Client> findAllByDeletedFalse();

    @Query(value = "SELECT * FROM client WHERE id = ?1 AND deleted = false", nativeQuery = true)
    Client findByIdAndByDeletedFalse(Long id);

    Client findByPhone(String phone);
}
