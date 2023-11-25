package backend.log.service;

import backend.log.entity.LogEntity;
import backend.log.model.Log;
import backend.log.repository.LogRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class LogServiceImpl implements LogService{
    @Autowired
    LogRepository logRepository;
    @Override
    public void ingestLog(Log log) {
        LogEntity logEntity = new LogEntity();
        BeanUtils.copyProperties(log,logEntity);
        logRepository.save(logEntity);
    }

    @Override
    public List<LogEntity> findByLevel(String level) {
        return logRepository.findByLevel(level);
    }

    @Override
    public List<LogEntity> findByMessage(String message) {
        return logRepository.findByMessage(message);
    }

    @Override
    public List<Log> findByResourceId(String resourceId) {
        List<LogEntity> logEntities = logRepository.findByResourceId(resourceId);
        List<Log> logs = logEntities.stream().map(log->new Log(
            log.getId(),
            log.getLevel(),
            log.getMessage(),
            log.getResourceId(),
            log.getTimeStamp(),
            log.getTraceId(),
            log.getSpanId(),
            log.getCommit()
        )).collect(Collectors.toList());
        return logs;
    }

    @Override
    public List<Log> findByTimeStamp(Instant timeStamp) {
        List<LogEntity> logEntities = logRepository.findByTimeStamp(timeStamp);
        List<Log> logs = logEntities.stream().map(log->new Log(
            log.getId(),
            log.getLevel(),
            log.getMessage(),
            log.getResourceId(),
            log.getTimeStamp(),
            log.getTraceId(),
            log.getSpanId(),
            log.getCommit()
        )).collect(Collectors.toList());
        return logs;
    }
}
