package mimsoft.io.lemenu.product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    boolean save(ProductDto productDto);

    List<ProductDto> getAll();

    ProductDto findById(Long id);

    boolean update(ProductDto productDto);

    boolean delete(Long id);
}
