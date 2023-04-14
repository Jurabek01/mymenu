package mimsoft.io.lemenu.product.productToLabel;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(
        name = "product_to_label",
        uniqueConstraints = {
                @UniqueConstraint(
                        columnNames = {"product_id", "label_id"}
                )
        }
)
public class ProductToLabel {
    private static final String SEQ_NAME = "option_to_extra_seq";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_NAME)
    @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME, allocationSize = 1)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;
    @Column(name = "product_id")
    private Long productId;
    @Column(name = "label_id")
    private Long labelId;
}
