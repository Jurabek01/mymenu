package mimsoft.io.lemenu.device.service;

import mimsoft.io.lemenu.device.Device;

import java.util.List;

public interface DeviceService {
    List<Device> getAll();
    Device get(Long id);
    Device getByPhone(String phone);
    Device save(Device device);
    boolean update(Device device);
    boolean delete(Long id);
}
