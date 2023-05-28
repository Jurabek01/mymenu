package mimsoft.io.lemenu.client.auth.service;

import mimsoft.io.lemenu.client.auth.JwtRequest;
import mimsoft.io.lemenu.client.auth.JwtResponse;
import mimsoft.io.lemenu.device.Device;
import mimsoft.io.lemenu.device.DeviceDto;

public interface AuthService {

    String sendCode(Device device);

    JwtResponse refresh(String refreshToken);

    JwtResponse verifyCode(Long code);
}
