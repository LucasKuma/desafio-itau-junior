package com.itau.project.service;

import com.itau.project.model.Transacao;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Getter
public class TransacaoServiceImpl implements TransacaoService{

    private List<Transacao> transacoes;

    public TransacaoServiceImpl(List<Transacao> transacoes) {
        this.transacoes = transacoes;
    }

    @Override
    public void createTransaction(Transacao transacao) {
        transacoes.add(transacao);
    }

    @Override
    public void deleteAllTransactions() {
        transacoes.clear();
    }

}
