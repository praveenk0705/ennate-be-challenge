package fi.pku.api.controller;

import fi.pku.api.dao.MetricDao;
import fi.pku.api.document.Metric;
import fi.pku.api.repository.MetricRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apiservices/")
public class MetricController {
    @Autowired
    private MetricDao metricDao;
    private MetricRepository metricRepository;

    public MetricController(MetricRepository metricRepository) {
        this.metricRepository = metricRepository;
    }

    @DeleteMapping("/deleteall")
        public void deleteAll(){
            metricRepository.deleteAll();
        }


    @PostMapping("/create")
    public void create(@RequestBody Metric metric){
        System.out.println("inside+++++++++++++++++===");
        //metricRepository.save(metric);
        metricDao.create(metric);
    }

    @GetMapping("/readall")
    //spring jpa mongoDB
/*
    public List<Metric> readAll(){
        return metricRepository.findAll();
    }
*/
    public ResponseEntity<List<Metric>> read() {

        List<Metric> metricList = metricDao.read();
        if (metricList.size() == 0)
            return new ResponseEntity<List<Metric>>(metricList, HttpStatus.NO_CONTENT);

        return new ResponseEntity<List<Metric>>(metricList, HttpStatus.OK);
    }
}
