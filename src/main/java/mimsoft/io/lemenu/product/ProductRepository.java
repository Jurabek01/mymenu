package mimsoft.io.lemenu.product;

import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Long> {

//    @Query(value = "SELECT * from product where id = :id", nativeQuery = true)
//    Optional<Dish> findById(Long id);

}
