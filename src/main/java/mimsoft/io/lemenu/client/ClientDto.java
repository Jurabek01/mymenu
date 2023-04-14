package mimsoft.io.lemenu.client;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClientDto {
    private Long id;
    private String phone;
    private String firstName;
    private String lastName;
    private String image;
    private String birthDay;
}
