package backend.log.repository;

import backend.log.entity.LogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LogRepository extends JpaRepository<LogEntity, Long> {
    List<LogEntity> findByLevel(String level);

    List<LogEntity> findByMessage(String message);
}
