package mimsoft.io.lemenu.product;

import mimsoft.io.lemenu.option.Option;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByDeletedFalse();

    @Query(value = "SELECT * FROM product WHERE id = ?1 AND deleted = false", nativeQuery = true)
    Product findByIdAndByDeletedFalse(Long id);

//    @Query(value = "SELECT * from product where id = :id", nativeQuery = true)
//    Optional<Dish> findById(Long id);

}
