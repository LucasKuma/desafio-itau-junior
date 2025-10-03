package com.itau.project.controller;

import com.itau.project.dto.TransacaoDTO;
import com.itau.project.model.Transacao;
import com.itau.project.service.TransacaoService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    @Autowired
    private TransacaoService transacaoService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<Void> createTransaction(@Valid @RequestBody TransacaoDTO transacaoDto) {
        if (transacaoDto.getValor() < 0 || transacaoDto.getDataHora().isAfter(OffsetDateTime.now()) || transacaoDto.getValor() == null || transacaoDto.getDataHora() == null) {
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
        Transacao transacao = modelMapper.map(transacaoDto, Transacao.class);
        transacaoService.createTransaction(transacao);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
