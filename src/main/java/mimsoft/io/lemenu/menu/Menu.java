package mimsoft.io.lemenu.menu;

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
@Table(name = "menu")
public class Menu {
    private static final String SEQ_NAME = "menu_seq";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_NAME)
    @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME, allocationSize = 1)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;
    private String nameUz;
    private String nameRu;
    private String nameEng;
}
