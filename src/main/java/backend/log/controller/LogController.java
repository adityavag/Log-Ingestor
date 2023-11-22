package backend.log.controller;

import backend.log.model.Log;
import backend.log.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogController {

    @Autowired
    LogService logService;

    @PostMapping("/logs")
    public ResponseEntity<String> ingestLog(@RequestBody Log log) {
        logService.ingestLog(log);
        return ResponseEntity.ok("Success");
    }
}
