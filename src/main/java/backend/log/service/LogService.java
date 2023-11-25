package backend.log.service;

import backend.log.entity.LogEntity;
import backend.log.model.Log;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

public interface LogService {
    void ingestLog(Log log);

    List<LogEntity> findByLevel(String level);

    List<Log> findByMessage(String message);

    List<Log> findByResourceId(String resourceId);

    List<Log> findByTimeStamp(Instant timeStamp);

    List<Log> findByTraceId(String traceId);

    List<Log> findBySpanId(String spanId);

    List<Log> findByCommit(String commit);
}
