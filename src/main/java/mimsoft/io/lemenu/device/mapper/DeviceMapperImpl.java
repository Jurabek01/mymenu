package mimsoft.io.lemenu.device.mapper;

import mimsoft.io.lemenu.device.Device;
import mimsoft.io.lemenu.device.DeviceDto;
import mimsoft.io.lemenu.device.mapper.DeviceMapper;
import org.springframework.stereotype.Service;

@Service
public class DeviceMapperImpl implements DeviceMapper {
    @Override
    public Device toEntity(DeviceDto deviceDto) {
        return Device.builder()
                .id(deviceDto.getId())
                .phone(deviceDto.getPhone())
                .uuid(deviceDto.getUuid())
                .firebaseToken(deviceDto.getFirebaseToken())
                .build();
    }

    @Override
    public DeviceDto toDto(Device device) {
        return DeviceDto.builder()
                .id(device.getId())
                .phone(device.getPhone())
                .uuid(device.getUuid())
                .firebaseToken(device.getFirebaseToken())
                .build();
    }
}
