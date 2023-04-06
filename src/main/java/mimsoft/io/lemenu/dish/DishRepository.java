package mimsoft.io.lemenu.dish;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface DishRepository extends JpaRepository<Dish, Long> {
    Dish findFirstByName(String name);


//    @Query(value = "SELECT * from dish where id = :id", nativeQuery = true)
//    Optional<Dish> findById(Long id);

}
