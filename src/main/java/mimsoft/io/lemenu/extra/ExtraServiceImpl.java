package mimsoft.io.lemenu.extra;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import lombok.SneakyThrows;
import mimsoft.io.lemenu.product.ProductController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExtraServiceImpl implements ExtraService {
    private final ExtraRepository extraRepository;

    private final Logger logger = LoggerFactory.getLogger(ProductController.class);

    public ExtraServiceImpl(ExtraRepository extraRepository) {
        this.extraRepository = extraRepository;
    }

    @Override
    @Transactional
    public boolean save(Extra extra) {
        extraRepository.save(extra);
        return true;
    }

    @Override
    public List<Extra> getAll() {
        return extraRepository.findAll();
    }

    @Override
    public Optional<Extra> findById(Long id) {
        return extraRepository.findById(id);
    }

    @Override
    @Transactional
    public boolean update(Extra extra) {
        extraRepository.findById(extra.getId())
                .orElseThrow(() -> new RuntimeException("Product not found"));
        extraRepository.save(extra);
        return true;
    }

    @Override
    public boolean delete(Long id) {
        Extra extra = extraRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        extraRepository.delete(extra);
        return true;
    }

}
