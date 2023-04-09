package mimsoft.io.lemenu.option.optionToExtra;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

@Entity
@Table(
        name = "option_to_extra",
        uniqueConstraints = {
                @UniqueConstraint(
                        columnNames = {"option_id", "extra_id"}
                )
        }
)
public class OptionToExtra {
    private static final String SEQ_NAME = "option_to_extra_seq";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_NAME)
    @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME, allocationSize = 1)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;
    @Column(name = "option_id")
    private Long optionId;
    @Column(name = "extra_id")
    private Long extraId;
}
