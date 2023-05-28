package mimsoft.io.lemenu.session.service;

import lombok.RequiredArgsConstructor;
import mimsoft.io.lemenu.session.Session;
import mimsoft.io.lemenu.session.SessionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SessionServiceImpl implements SessionService {

    private final SessionRepository sessionRepository;
    @Override
    public List<Session> getAll() {
        return sessionRepository.findAll();
    }

    @Override
    public Session get(Long id) {
        Optional<Session> session = sessionRepository.findById(id);
        return session.orElse(null);
    }

    @Override
    public Session getByUuid(String uuid) {
        return sessionRepository.findByUuid(uuid);
    }

    @Override
    public boolean save(Session session) {
        Session session1 = sessionRepository.save(session);
        return true;
    }

    @Override
    public String generateUuid() {
        return UUID.randomUUID().toString();
    }
}
