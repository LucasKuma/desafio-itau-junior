package com.itau.project.service;

import com.itau.project.model.Transacao;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.DoubleSummaryStatistics;

@Service
public class EstatisticaServiceImpl implements EstatisticaService{

    private TransacaoServiceImpl transacaoServiceImpl;

    public EstatisticaServiceImpl(TransacaoServiceImpl transacaoServiceImpl) {
        this.transacaoServiceImpl = transacaoServiceImpl;
    }

    @Override
    public DoubleSummaryStatistics getStatistics() {

        return transacaoServiceImpl.getTransacoes().stream()
                .filter(transacao -> transacao.getDataHora().isAfter(OffsetDateTime.now().minusSeconds(60)))
                .mapToDouble(Transacao::getValor)
                .summaryStatistics();
    }
}
