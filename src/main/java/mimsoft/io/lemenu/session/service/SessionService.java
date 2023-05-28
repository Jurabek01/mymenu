package mimsoft.io.lemenu.session.service;

import mimsoft.io.lemenu.session.Session;

import java.util.List;
import java.util.Optional;

public interface SessionService {
    List<Session> getAll();
    Session get(Long id);
    Session getByUuid(String uuid);
    boolean save(Session session);

    String generateUuid();

}
