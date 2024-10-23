package com.example.exemplodto.mapper;

import com.example.exemplodto.dtos.JogadorResponseDTO;
import com.example.exemplodto.models.JogadorEntidade;
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
