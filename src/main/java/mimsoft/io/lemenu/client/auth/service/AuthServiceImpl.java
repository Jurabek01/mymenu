package mimsoft.io.lemenu.client.auth.service;

import lombok.RequiredArgsConstructor;
import mimsoft.io.lemenu.client.service.ClientService;
import mimsoft.io.lemenu.client.auth.JwtResponse;
import mimsoft.io.lemenu.device.Device;
import mimsoft.io.lemenu.device.service.DeviceService;
import mimsoft.io.lemenu.security.JwtTokenProvider;
import mimsoft.io.lemenu.services.SMSService;
import mimsoft.io.lemenu.session.Session;
import mimsoft.io.lemenu.session.service.SessionService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final ClientService clientService;
    private final JwtTokenProvider jwtTokenProvider;
    private final SMSService smsService;
    private final DeviceService deviceService;
    private final SessionService sessionService;

    @Override
    public String sendCode(Device device) {
        Device savedDevice = deviceService.save(device);
        Long code = smsService.send(device.getPhone());
        String sessionUuid = sessionService.generateUuid();
        sessionService.save(Session.builder()
                        .deviceId(savedDevice.getId())
                        .phone(device.getPhone())
                        .verifyCode(code)
                        .uuid(sessionUuid)
                        .build());
        return jwtTokenProvider.createVerifyToken(savedDevice.getId(), sessionUuid);
    }

    @Override
    public JwtResponse refresh(String refreshToken) {
        return null;
    }

    @Override
    public JwtResponse verifyCode(Long code) {
        Session session = sessionService.getByUuid();
        return null;
    }
}
