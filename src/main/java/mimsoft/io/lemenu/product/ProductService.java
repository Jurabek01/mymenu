package mimsoft.io.lemenu.product;

import java.util.List;

public interface ProductService {
    boolean save(ProductDto productDto);

    List<ProductDto> getAll();

    ProductDto get(Long id);

    boolean update(ProductDto productDto);

    boolean delete(Long id);
}
