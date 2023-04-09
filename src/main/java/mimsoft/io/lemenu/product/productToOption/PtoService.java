package mimsoft.io.lemenu.product.productToOption;

import java.util.List;

public interface PtoService {
    List<ProductToOption> getAllByProductId(Long id);
    List<ProductToOption> getAllByOptionId(Long id);
    ProductToOption save(ProductToOption productToOption);
    ProductToOption get(Long productId, Long optionId);
    boolean deleteByProductId(Long id);
    boolean deleteByOptionId(Long id);
}
