package mimsoft.io.lemenu.client.auth;

import lombok.RequiredArgsConstructor;
import mimsoft.io.lemenu.client.mapper.ClientMapper;
import mimsoft.io.lemenu.client.service.ClientService;
import mimsoft.io.lemenu.client.auth.service.AuthService;
import mimsoft.io.lemenu.device.Device;
import mimsoft.io.lemenu.device.DeviceDto;
import mimsoft.io.lemenu.device.mapper.DeviceMapper;
import mimsoft.io.lemenu.device.service.DeviceService;
import mimsoft.io.lemenu.services.SMSService;
import org.springframework.http.HttpStatus;
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
    private final DeviceMapper deviceMapper;

    @PostMapping("/send-code")
    public ResponseEntity<?> sendCode(@RequestBody DeviceDto deviceDto) {
        return new ResponseEntity<>(authService.sendCode(deviceMapper.toEntity(deviceDto)), HttpStatus.OK);
    }

    @PostMapping("/verify-code")
    public ResponseEntity<?> verifyCode(@RequestBody Long verifyCode) {

    }
}
