package mimsoft.io.lemenu.product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    boolean save(Product product);

    List<Product> getAll();

    Optional<Product> findById(Long id);

    boolean update(Product product);

    boolean delete(Long id);
}
