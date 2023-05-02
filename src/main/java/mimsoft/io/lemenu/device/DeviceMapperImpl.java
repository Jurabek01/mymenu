package mimsoft.io.lemenu.device;

import org.springframework.stereotype.Service;

@Service
public class DeviceMapperImpl implements DeviceMapper {
    @Override
    public Device toEntity(DeviceDto deviceDto) {
        return Device.builder()
                .id(deviceDto.getId())
                .phone(deviceDto.getPhone())
                .firebaseToken(deviceDto.getFirebaseToken())
                .build();
    }

    @Override
    public DeviceDto toDto(Device device) {
        return DeviceDto.builder()
                .id(device.getId())
                .phone(device.getPhone())
                .firebaseToken(device.getFirebaseToken())
                .build();
    }
}
