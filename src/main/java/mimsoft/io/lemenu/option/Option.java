package mimsoft.io.lemenu.option;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mimsoft.io.lemenu.dish.Dish;
import mimsoft.io.lemenu.extra.Extra;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "option")
public class Option {
    private static final String SEQ_NAME = "option_seq";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_NAME)
    @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME, allocationSize = 1)
    private Long id;
    private String name;
    private String description;
    @OneToMany(mappedBy = "option",cascade = CascadeType.ALL)
    private List<Extra> extras;
    @ManyToOne
    @JoinColumn(name = "dish_id")
    private Dish dish;

}

