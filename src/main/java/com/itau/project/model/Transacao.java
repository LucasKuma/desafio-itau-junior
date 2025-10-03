package com.itau.project.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
public class Transacao {

    private Double valor;

    private OffsetDateTime dataHora;

    public Transacao(Double valor, OffsetDateTime dataHora) {
        this.valor = valor;
        this.dataHora = dataHora;
    }
}
