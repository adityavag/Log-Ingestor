package backend.log.service;

import backend.log.entity.LogEntity;
import backend.log.model.Log;
import backend.log.repository.LogRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
