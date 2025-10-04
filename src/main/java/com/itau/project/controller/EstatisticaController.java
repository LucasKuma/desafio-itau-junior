package com.itau.project.controller;

import com.itau.project.service.EstatisticaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.DoubleSummaryStatistics;

@RestController
@RequestMapping("/estatistica")
public class EstatisticaController {

    @Autowired
    private EstatisticaService estatisticaService;

    @GetMapping
    public ResponseEntity<DoubleSummaryStatistics> getStatistics() {
        return new ResponseEntity<>(estatisticaService.getStatistics(), HttpStatus.OK);
    }
}
