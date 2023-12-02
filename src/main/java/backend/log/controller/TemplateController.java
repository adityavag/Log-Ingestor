package backend.log.controller;

import backend.log.model.Log;
import backend.log.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TemplateController {
    @Autowired
    LogService logService;
    @GetMapping("/")
    public String getIndex() {
        return "index";
    }
    @GetMapping("/getLogs")
    public String getAllLogs(Model model) {
        model.addAttribute("logs",logService.getAllLogs());
        return "all-logs" ;
    }
}
