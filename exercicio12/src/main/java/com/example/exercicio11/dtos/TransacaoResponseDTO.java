package com.example.exercicio11.dtos;

public record TransacaoResponseDTO(ContaDTO origem, ContaDTO destino, Double valor) {
}
