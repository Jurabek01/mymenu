package mimsoft.io.lemenu.product;

import jakarta.transaction.Transactional;
import lombok.SneakyThrows;
import mimsoft.io.lemenu.content.TextModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private final Logger logger = LoggerFactory.getLogger(ProductController.class);

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    @Transactional
    public boolean save(ProductDto productDto) {
        productRepository.save(fromDto(productDto));
        return true;
    }

    @Override
    public List<ProductDto> getAll() {
        return productRepository.findAllByDeletedFalse().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }


    @Override
    public ProductDto get(Long id) {
        Product product = productRepository.findByIdAndByDeletedFalse(id);
        if (product==null) {
            return null;
        }
        else
            return toDto(product);
    }

    @SneakyThrows
    @Override
    @Transactional
    public boolean update(ProductDto productDto) {
        Product productOptional = productRepository.findByIdAndByDeletedFalse(productDto.getId());
        if (productOptional!=null) {
            productRepository.save(fromDto(productDto));
            return true;
        }
        else
            return false;
    }

    @Override
    public boolean delete(Long id) {
        Product product = productRepository.findByIdAndByDeletedFalse(id);
        if (product!=null) {
            product.setDeleted(true);
            productRepository.save(product);
            return true;
        }
        return false;
    }

    private ProductDto toDto(Product product) {
        return ProductDto.builder()
                .id(product.getId())
                .menuId(product.getMenuId())
                .name(
                        new TextModel(
                                product.getNameUz(),
                                product.getNameRu(),
                                product.getNameEng()
                        )
                )
                .image(product.getImage())
                .costPrice(product.getCostPrice())
                .description(
                        new TextModel(
                                product.getNameUz(),
                                product.getNameRu(),
                                product.getNameEng()
                        )
                )
                .build();
    }

    private Product fromDto(ProductDto productDto) {
        return Product.builder()
                .id(productDto.getId())
                .menuId(productDto.getMenuId())
                .nameUz(productDto.getName().getUz())
                .nameRu(productDto.getName().getRu())
                .nameEng(productDto.getName().getEng())
                .image(productDto.getImage())
                .costPrice(productDto.getCostPrice())
                .descriptionUz(productDto.getDescription().getUz())
                .descriptionRu(productDto.getDescription().getRu())
                .descriptionEng(productDto.getDescription().getEng())
                .build();
    }
}
