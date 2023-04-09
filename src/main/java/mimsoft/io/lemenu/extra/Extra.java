package mimsoft.io.lemenu.extra;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mimsoft.io.lemenu.content.TextModel;
import mimsoft.io.lemenu.option.Option;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "extra")
public class Extra {
    private static final String SEQ_NAME = "extra_seq";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_NAME)
    @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME, allocationSize = 1)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;
    private String nameUz;
    private String nameRu;
    private String nameEng;
    private String price;
    private String description;
}

