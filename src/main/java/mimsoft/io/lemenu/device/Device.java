package mimsoft.io.lemenu.device;

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
@Table(name = "device")
public class Device {
    private static final String SEQ_NAME = "device_seq";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_NAME)
    @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME, allocationSize = 1)
    private Long id;
    private String firebaseToken;
    private String phone;

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
