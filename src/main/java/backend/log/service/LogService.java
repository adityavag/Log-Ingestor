package backend.log.service;

import backend.log.model.Log;
import org.springframework.stereotype.Service;

public interface LogService {
    void ingestLog(Log log);
}
