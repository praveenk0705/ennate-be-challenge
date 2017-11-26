package fi.pku.api.controller;

import fi.pku.api.document.Alert;
import fi.pku.api.repository.AlertRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apiservices/")
public class AlertController {
    private AlertRepository alertRepository;

    public AlertController(AlertRepository alertRepository) {
        this.alertRepository = alertRepository;
    }

    @GetMapping("/readallalert")
    public List<Alert> readAll(){
        return alertRepository.findAll();
    }
    @PostMapping("/createalert")
    public void create(@RequestBody Alert alert){
        alertRepository.save(alert);
    }
}
