package mimsoft.io.lemenu.label;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mimsoft.io.lemenu.product.Product;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "label")
public class Label {
    private static final String SEQ_NAME = "label_seq";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_NAME)
    @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME, allocationSize = 1)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;
    private Long menuId;
    private String nameUz;
    private String nameRu;
    private String nameEng;
    private String textColor;
    private String bgColor;
    private String icon;
}
