package mimsoft.io.lemenu.dish;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mimsoft.io.lemenu.option.Option;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "dish")
public class Dish {
    private static final String SEQ_NAME = "dish_seq";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_NAME)
    @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME, allocationSize = 1)
    private Long id;
    private Long menuId;
    private String name;
    private String image;
    private String description;
    private BigDecimal costPrice;
    @OneToMany(mappedBy = "dish", cascade = CascadeType.ALL)
    private List<Option> options;

}