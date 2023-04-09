package mimsoft.io.lemenu.product.productToOption;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PtoRepository extends JpaRepository<ProductToOption, Long> {
    List<ProductToOption> getAllByProductId(Long id);
    List<ProductToOption> getAllByOptionId(Long id);
    ProductToOption getByProductIdAndOptionId(Long productId, Long optionId);
    boolean deleteByProductId(Long id);
    boolean deleteByOptionId(Long id);
}
