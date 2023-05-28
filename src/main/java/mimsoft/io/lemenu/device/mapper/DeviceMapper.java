package mimsoft.io.lemenu.device.mapper;

import mimsoft.io.lemenu.device.Device;
import mimsoft.io.lemenu.device.DeviceDto;

public interface DeviceMapper {
    Device toEntity(DeviceDto deviceDto);
    DeviceDto toDto(Device device);
}
