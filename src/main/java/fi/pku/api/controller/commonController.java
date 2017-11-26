package fi.pku.api.controller;

import fi.pku.api.dao.AlertDao;
import fi.pku.api.dao.MetricDao;
import fi.pku.api.document.Alert;
import fi.pku.api.document.Metric;
import fi.pku.api.rules.Rules;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/weightapi/")
public class commonController {
    @Autowired
    private MetricDao metricDao;
    @Autowired
    private AlertDao alertDao;

    @GetMapping("/get-alert-list")
    public ResponseEntity<List<Alert>> readAllAlert() {

        List<Alert> alertList= alertDao.read();
        if (alertList.size() == 0)
            return new ResponseEntity<List<Alert>>(alertList, HttpStatus.NO_CONTENT);

        return new ResponseEntity<List<Alert>>(alertList, HttpStatus.OK);
    }

    @GetMapping("/get-metric-list")
    public ResponseEntity<List<Metric>> readAllMetric() {

        List<Metric> metricList = metricDao.read();
        if (metricList.size() == 0)
            return new ResponseEntity<List<Metric>>(metricList, HttpStatus.NO_CONTENT);

        return new ResponseEntity<List<Metric>>(metricList, HttpStatus.OK);
    }


    @PostMapping("create")
    public ResponseEntity create(@RequestBody Metric metric){
        //TODO logic for rules
        Rules rule = new Rules();
        String result = rule.calculate(metric.getValue());
        if (result.equals("overweight")|| result.equals("underweight")){
            Alert a = new Alert();
            a.setTimeStamp(metric.getTimeStamp());
            a.setValue(metric.getValue());
            a.setAlertType(result);
            alertDao.create(a);
            return new ResponseEntity((HttpStatus.CREATED));
        }
        else{
            metricDao.create(metric);
            return new ResponseEntity(HttpStatus.CREATED);
        }





    }


    @RequestMapping(value = "/readMetricRange/{startTime}/{endTime}")
    public ResponseEntity<List<Metric>> readMetricData(@PathVariable Long startTime, @PathVariable Long endTime) {

        if (startTime == null || endTime == null)
            return new ResponseEntity<List<Metric>>(new ArrayList<Metric>(), HttpStatus.BAD_REQUEST);

        List<Metric> metricList = metricDao.rangeRead(startTime, endTime);

        if (metricList.size() == 0)
            return new ResponseEntity<List<Metric>>(metricList, HttpStatus.NO_CONTENT);

        return new ResponseEntity<List<Metric>>(metricList, HttpStatus.OK);
    }

    @RequestMapping(value = "/readAlertRange/{startTime}/{endTime}")
    public ResponseEntity<List<Alert>> readAlertData(@PathVariable Long startTime, @PathVariable Long endTime) {

        if (startTime == null || endTime == null)
            return new ResponseEntity<List<Alert>>(new ArrayList<Alert>(), HttpStatus.BAD_REQUEST);

        List<Alert> alertList = alertDao.rangeRead(startTime, endTime);

        if (alertList.size() == 0)
            return new ResponseEntity<List<Alert>>(alertList, HttpStatus.NO_CONTENT);

        return new ResponseEntity<List<Alert>>(alertList, HttpStatus.OK);
    }
}
