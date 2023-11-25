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
//
    @PostMapping("/logs")
    public ResponseEntity<String> ingestLog(@RequestBody Log log) {
        logService.ingestLog(log);
        return ResponseEntity.ok("Success");
    }
//
    @GetMapping("/logs")
    public ResponseEntity<List<Log>> getAllLogs() {
        List<Log> logs = logService.getAllLogs();
        return ResponseEntity.ok(logs);
    }
//  Query By Level
    @GetMapping("/logs/level/{level}")
    public ResponseEntity<List<Log>> findByLevel(@PathVariable String level) {
        List<Log> logs = logService.findByLevel(level);
        return ResponseEntity.ok(logs);
    }

//    Query By Message
    @GetMapping("/logs/message/{message}")
    public ResponseEntity<List<Log>> findByMessage(@PathVariable String message) {
        List<Log> logs = logService.findByMessage(message);
        return ResponseEntity.ok(logs);
    }
//    Query By resourceId
    @GetMapping("/logs/resource/{resourceId}]")
    public ResponseEntity<List<Log>> findByResourceId(@PathVariable String resourceId) {
        List<Log> logs = logService.findByResourceId(resourceId);
        return ResponseEntity.ok(logs);
    }
//    Query By timeStamp
    @GetMapping("/logs/timestamp/{timeStamp}")
    public ResponseEntity<List<Log>> findByTimeStamp(@PathVariable Instant timeStamp) {
        List<Log> logs = logService.findByTimeStamp(timeStamp);
        return ResponseEntity.ok(logs);
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
