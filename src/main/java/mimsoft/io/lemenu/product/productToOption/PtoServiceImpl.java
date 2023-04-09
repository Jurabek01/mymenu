package mimsoft.io.lemenu.product.productToOption;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PtoServiceImpl implements PtoService {
    private final PtoRepository ptoRepository;

    public PtoServiceImpl(PtoRepository ptoRepository) {
        this.ptoRepository = ptoRepository;
    }

    @Override
    public List<ProductToOption> getAllByProductId(Long id) {
        return ptoRepository.getAllByProductId(id);
    }

    @Override
    public List<ProductToOption> getAllByOptionId(Long id) {
        return ptoRepository.getAllByOptionId(id);
    }

    @Override
    public ProductToOption save(ProductToOption productToOption) {
        return ptoRepository.save(productToOption);
    }

    @Override
    public ProductToOption get(Long productId, Long optionId) {
        return ptoRepository.getByProductIdAndOptionId(productId, optionId);
    }

    @Override
    public boolean deleteByProductId(Long id) {
        return ptoRepository.deleteByProductId(id);
    }

    @Override
    public boolean deleteByOptionId(Long id) {
        return ptoRepository.deleteByOptionId(id);
    }
}
