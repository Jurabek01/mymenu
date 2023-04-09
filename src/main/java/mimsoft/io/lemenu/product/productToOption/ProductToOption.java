package mimsoft.io.lemenu.product.productToOption;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

@Entity
@Table(
        name = "product_to_option",
        uniqueConstraints = {
                @UniqueConstraint(
                        columnNames = {"product_id", "option_id"}
                )
        }
)
public class ProductToOption {
    private static final String SEQ_NAME = "product_to_option_seq";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_NAME)
    @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME, allocationSize = 1)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;
    @Column(name = "product_id")
    private Long productId;
    @Column(name = "option_id")
    private Long optionId;
}
