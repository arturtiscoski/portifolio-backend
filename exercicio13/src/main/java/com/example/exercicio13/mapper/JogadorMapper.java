package com.example.exercicio13.mapper;

import com.example.exercicio13.dtos.JogadorResponseDTO;
import com.example.exercicio13.models.JogadorEntidade;
import org.springframework.stereotype.Component;

@Component
public class JogadorMapper {
    public JogadorResponseDTO toDto(JogadorEntidade jogador) {
        return new JogadorResponseDTO(
                jogador.getApelido(),
                jogador.getHabilidade()
        );
    }
}
