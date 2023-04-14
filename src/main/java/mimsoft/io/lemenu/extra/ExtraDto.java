package mimsoft.io.lemenu.extra;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mimsoft.io.lemenu.content.TextModel;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExtraDto {
    private Long id;
    private TextModel name;
    private String price;
    private TextModel description;
}
