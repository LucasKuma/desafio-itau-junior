package com.itau.project.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
public class TransacaoDTO {

    @NotNull
    private Double valor;

    @NotNull
    private OffsetDateTime dataHora;
}
