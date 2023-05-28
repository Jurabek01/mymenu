package mimsoft.io.lemenu.session;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session, Long> {
    Session findByUuid(String uuid);
}
