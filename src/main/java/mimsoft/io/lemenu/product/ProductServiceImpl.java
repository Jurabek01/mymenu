package mimsoft.io.lemenu.product;

import jakarta.transaction.Transactional;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private final Logger logger = LoggerFactory.getLogger(ProductController.class);

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    @Transactional
    public boolean save(Product product) {
        productRepository.save(product);
        return true;
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }


    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @SneakyThrows
    @Override
    @Transactional
    public boolean update(Product product) {
        productRepository.findById(product.getId())
                .orElseThrow(() -> new RuntimeException("Product not found"));
        productRepository.save(product);
        return true;
    }

    @Override
    public boolean delete(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        productRepository.delete(product);
        return true;
    }
}
