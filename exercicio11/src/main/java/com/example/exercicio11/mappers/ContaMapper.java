package com.example.exercicio11.mappers;

import com.example.exercicio11.dtos.ContaDTO;
import com.example.exercicio11.models.Conta;

public class ContaMapper {
    public static ContaDTO toContaDTO(Conta conta) {
        return new ContaDTO(conta.getCodigo(), conta.getCliente());
    }
}
