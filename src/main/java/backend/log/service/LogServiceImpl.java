package backend.log.service;

import backend.log.entity.LogEntity;
import backend.log.model.Log;
import backend.log.repository.LogRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
