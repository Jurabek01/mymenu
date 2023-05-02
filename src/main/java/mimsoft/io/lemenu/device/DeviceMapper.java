package mimsoft.io.lemenu.device;

public interface DeviceMapper {
    Device toEntity(DeviceDto deviceDto);
    DeviceDto toDto(Device device);
}
