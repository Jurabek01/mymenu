package mimsoft.io.lemenu.client.auth;

import lombok.RequiredArgsConstructor;
import mimsoft.io.lemenu.client.ClientMapper;
import mimsoft.io.lemenu.client.ClientService;
import mimsoft.io.lemenu.device.DeviceDto;
import mimsoft.io.lemenu.device.DeviceMapper;
import mimsoft.io.lemenu.device.DeviceService;
import mimsoft.io.lemenu.services.SMSService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
@Validated
public class AuthController {

    private final AuthService authService;
    private final ClientService clientService;
    private final ClientMapper clientMapper;
    private final SMSService smsService;
    private final DeviceService deviceService;
    private DeviceMapper deviceMapper;

    @PostMapping("/send-code")
    public ResponseEntity<?> sendCode(@RequestBody DeviceDto deviceDto) {
        deviceService.save(deviceMapper.toEntity(deviceDto));
        smsService.send(deviceDto.getPhone());

    }
}
