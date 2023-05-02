package mimsoft.io.lemenu.device;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class DeviceServiceImpl implements DeviceService {

    private final DeviceRepository deviceRepository;
    @Override
    public List<Device> getAll() {
        return null;
    }

    @Override
    public Device get(Long id) {
        return null;
    }

    @Override
    public Device getByPhone(String phone) {
        return null;
    }

    @Override
    public boolean save(Device device) {
        return false;
    }

    @Override
    public boolean update(Device device) {
        return false;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }
}
