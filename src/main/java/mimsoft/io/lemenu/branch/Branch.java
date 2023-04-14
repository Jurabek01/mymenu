package mimsoft.io.lemenu.branch;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "branch")
public class Branch {
    private static final String SEQ_NAME = "branch_seq";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_NAME)
    @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME, allocationSize = 1)
    private Long id;
    private String nameUz;
    private String nameRu;
    private String nameEng;
    private Double longitude;
    private Double latitude;
    private String address;
    @Builder.Default
    private Boolean deleted = false;

    @Column(name = "created", updatable = false)
    private LocalDateTime created;

    @Column(name = "updated")
    private LocalDateTime updated;

    @PrePersist // вызывается перед сохранением новой сущности в базе данных
    public void prePersist() {
        this.created = LocalDateTime.now();
    }

    @PreUpdate // вызывается перед обновлением существующей сущности в базе данных
    public void preUpdate() {
        this.updated = LocalDateTime.now();
    }
}
