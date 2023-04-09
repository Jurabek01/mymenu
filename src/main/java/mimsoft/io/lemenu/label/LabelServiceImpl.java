package mimsoft.io.lemenu.label;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LabelServiceImpl implements LabelService {

    private final LabelRepository labelRepository;

    public LabelServiceImpl(LabelRepository labelRepository) {
        this.labelRepository = labelRepository;
    }

    @Override
    @Transactional
    public boolean save(Label label) {
        labelRepository.save(label);
        return true;
    }

    @Override
    public List<Label> getAll() {
        return labelRepository.findAll();
    }

    @Override
    public Optional<Label> findById(Long id) {
        return labelRepository.findById(id);
    }

    @Override
    public boolean update(Label label) {
        labelRepository.findById(label.getId())
                .orElseThrow(() -> new RuntimeException("Label not found"));
        labelRepository.save(label);
        return true;
    }

    @Override
    public boolean delete(Long id) {
        Label label = labelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Label not found"));
        labelRepository.delete(label);
        return false;
    }
}
