package com.itau.project.service;

import com.itau.project.model.Transacao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransacaoServiceImpl implements TransacaoService{

    private List<Transacao> transacoes;

    public TransacaoServiceImpl(List<Transacao> transacoes) {
        this.transacoes = transacoes;
    }

    @Override
    public void createTransaction(Transacao transacao) {
        transacoes.add(transacao);
    }

}
