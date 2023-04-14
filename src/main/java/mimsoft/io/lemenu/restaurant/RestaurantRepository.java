package mimsoft.io.lemenu.restaurant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    List<Restaurant> findAllByDeletedFalse();

    @Query(value = "SELECT * FROM restaurant WHERE id = ?1 AND deleted = false", nativeQuery = true)
    Restaurant findByIdAndByDeletedFalse(Long id);
}
