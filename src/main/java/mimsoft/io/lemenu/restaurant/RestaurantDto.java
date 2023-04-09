package mimsoft.io.lemenu.restaurant;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mimsoft.io.lemenu.content.TextModel;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RestaurantDto {
    private Long id;
    private String logo;
    private TextModel name;
    private String domain;
}
