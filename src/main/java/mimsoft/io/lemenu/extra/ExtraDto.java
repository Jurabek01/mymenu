package mimsoft.io.lemenu.extra;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mimsoft.io.lemenu.option.Option;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExtraDto {
    private String name;
    private String price;
    private String description;
    private Option option;
}
