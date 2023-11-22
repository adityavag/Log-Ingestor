package backend.log.service;

import backend.log.entity.LogEntity;
import backend.log.model.Log;
import org.springframework.stereotype.Service;

import java.util.List;

public interface LogService {
    void ingestLog(Log log);

    List<LogEntity> findByLevel(String level);
}
