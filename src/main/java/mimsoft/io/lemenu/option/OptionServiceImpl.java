package mimsoft.io.lemenu.option;

import mimsoft.io.lemenu.product.ProductService;
import mimsoft.io.lemenu.product.productToOption.PtoService;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class OptionServiceImpl implements OptionService{

    private final OptionRepository optionRepository;
    private final ProductService productService;

    private final PtoService ptoService;

    public OptionServiceImpl(OptionRepository optionRepository, ProductService productService, PtoService ptoService) {
        this.optionRepository = optionRepository;
        this.productService = productService;
        this.ptoService = ptoService;
    }

    @Override
    @Transactional
    public boolean save(Option option) {
        optionRepository.save(option);
        return true;
    }

    @Override
    public List<Option> getAll() {
        return optionRepository.findAll();
    }

    @Override
    public Optional<Option> findById(Long id) {
        return optionRepository.findById(id);
    }

    @Override
    public boolean update(Option option) {
        optionRepository.findById(option.getId())
                .orElseThrow(() -> new RuntimeException("Option not found"));
        optionRepository.save(option);
        return true;
    }

    @Override
    public boolean delete(Long id) {
        Option option = optionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Option not found"));
        optionRepository.delete(option);
        return false;
    }

}
