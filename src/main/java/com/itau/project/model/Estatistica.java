package com.itau.project.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Estatistica {

    private Long count;
    private Double sum;
    private Double avg;
    private Double min;
    private Double max;
}
