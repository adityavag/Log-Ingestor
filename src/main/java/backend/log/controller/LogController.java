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
    @GetMapping("/logs/resource/{resourceId}]")
    public List<Log> findByResourceId(@PathVariable String resourceId) {
        return logService.findByResourceId(resourceId);
    }
//    Query By timeStamp
    @GetMapping("/logs/timestamp/{timeStamp}")
    public List<Log> findByTimeStamp(@PathVariable Instant timeStamp) {
        return logService.findByTimeStamp(timeStamp);
    }
//    Query By traceId
    @GetMapping("/logs/trace/{traceId}")
    public ResponseEntity<List<Log>> findByTraceId(@PathVariable String traceId) {
        List<Log> logs = logService.findByTraceId(traceId);
        return ResponseEntity.ok(logs);
    }
//    Query By spanId
    @GetMapping("/logs/span/{spanId}")
    public ResponseEntity<List<Log>> findBySpanId(@PathVariable String spanId) {
        List<Log> logs = logService.findBySpanId(spanId);
        return ResponseEntity.ok(logs);
    }
//    Query By commit
    @GetMapping("/logs/commit/{commit}")
    public ResponseEntity<List<Log>> findByCommit(@PathVariable String commit) {
        List<Log> logs = logService.findByCommit(commit);
        return ResponseEntity.ok(logs);
    }
}
