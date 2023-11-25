package backend.log.controller;

import backend.log.entity.LogEntity;
import backend.log.model.Log;
import backend.log.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
public class LogController {

    @Autowired
    LogService logService;

    @PostMapping("/logs")
    public ResponseEntity<String> ingestLog(@RequestBody Log log) {
        logService.ingestLog(log);
        return ResponseEntity.ok("Success");
    }
//  Query By Level
    @GetMapping("/logs/level/{level}")
    public List<LogEntity> findByLevel(@PathVariable String level) {
        return logService.findByLevel(level);
    }

//    Query By Message
    @GetMapping("/logs/message/{message}")
    public List<Log> findByMessage(@PathVariable String message) {
        return logService.findByMessage(message);
    }
//    Query By resourceId
    @GetMapping("/logs/resourceid/{resourceId}]")
    public List<Log> findByResourceId(@PathVariable String resourceId) {
        return logService.findByResourceId(resourceId);
    }
//    Query By timeStamp
    @GetMapping("/logs/timeStamp/{timeStamp}")
    public List<Log> findByTimeStamp(@PathVariable Instant timeStamp) {
        return logService.findByTimeStamp(timeStamp);
    }
//    Query By traceId
//    Query By spanId
//    Query By commit
}
