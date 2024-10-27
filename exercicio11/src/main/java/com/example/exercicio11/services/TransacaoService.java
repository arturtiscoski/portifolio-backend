package com.example.exercicio11.services;

import com.example.exercicio11.dtos.TransacaoRequestDTO;
import com.example.exercicio11.dtos.TransacaoResponseDTO;
import com.example.exercicio11.mappers.ContaMapper;
import com.example.exercicio11.models.Conta;
import com.example.exercicio11.models.Transacao;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class TransacaoService {
    private List<Conta> contas;

    public TransacaoService() {
        this.contas = new ArrayList<>();
        inicializarContas();
    }

    private void inicializarContas() {
        Conta conta1 = new Conta("500-1", "Fulano");
        Conta conta2 = new Conta("320-2", "Ciclano");
        contas.add(conta1);
        contas.add(conta2);
    }

    public List<Conta> getContas() {
        return contas;
    }

    public TransacaoResponseDTO criarTransacao(TransacaoRequestDTO request) {
        Conta origem = buscarContaPorCodigo(request.origem());
        Conta destino = buscarContaPorCodigo(request.destino());

        if (origem == null || destino == null) {
            throw new IllegalArgumentException("Conta origem ou destino inválida.");
        }

        Transacao transacao = new Transacao(origem, destino, request.valor());
        return new TransacaoResponseDTO(
                ContaMapper.toContaDTO(transacao.getOrigem()),
                ContaMapper.toContaDTO(transacao.getDestino()),
                transacao.getValor()
        );
    }

    private Conta buscarContaPorCodigo(String codigo) {
        return contas.stream()
                .filter(conta -> conta.getCodigo().equals(codigo))
                .findFirst()
                .orElse(null);
    }

}
