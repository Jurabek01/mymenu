package mimsoft.io.lemenu.category;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mimsoft.io.lemenu.content.TextModel;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryDto {
    protected Long id;
    protected String image;
    private TextModel name;
}
