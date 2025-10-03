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
        if (transacaoDto.getValor() < 0 || transacaoDto.getDataHora().isAfter(OffsetDateTime.now())) {
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
        transacaoService.createTransaction(modelMapper.map(transacaoDto, Transacao.class));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAllTransactions() {
        transacaoService.deleteAllTransactions();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
