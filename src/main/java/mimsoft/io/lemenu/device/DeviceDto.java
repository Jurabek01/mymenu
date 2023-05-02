package mimsoft.io.lemenu.device;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeviceDto {
    private Long id;
    private String firebaseToken;
    private String phone;
}
