package mimsoft.io.lemenu.device.service;

import lombok.RequiredArgsConstructor;
import mimsoft.io.lemenu.device.Device;
import mimsoft.io.lemenu.device.DeviceRepository;
import mimsoft.io.lemenu.device.service.DeviceService;
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
    public Device save(Device device) {
        return deviceRepository.save(device);
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
