package backend.log.controller;

import backend.log.entity.LogEntity;
import backend.log.model.Log;
import backend.log.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/logs/level/{level}")
    public List<LogEntity> findByLevel(@PathVariable String level) {
        return logService.findByLevel(level);
    }
}
