package mimsoft.io.lemenu.label;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mimsoft.io.lemenu.content.TextModel;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LabelDto {
    private Long id;
    private Long menuId;
    private TextModel name;
    private String textColor;
    private String bgColor;
    private String icon;
}
