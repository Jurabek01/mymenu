package mimsoft.io.lemenu.branch;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mimsoft.io.lemenu.content.TextModel;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BranchDto {
    private Long id;
    private TextModel name;
    private Double longitude;
    private Double latitude;
    private String address;
}
