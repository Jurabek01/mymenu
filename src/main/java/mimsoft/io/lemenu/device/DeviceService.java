package mimsoft.io.lemenu.device;

import java.util.List;

public interface DeviceService {
    List<Device> getAll();
    Device get(Long id);
    Device getByPhone(String phone);
    boolean save(Device device);
    boolean update(Device device);
    boolean delete(Long id);
}
