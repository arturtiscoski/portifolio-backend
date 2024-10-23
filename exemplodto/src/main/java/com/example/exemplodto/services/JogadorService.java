package com.example.exemplodto.services;

import com.example.exemplodto.dtos.JogadorRequestDTO;
import com.example.exemplodto.dtos.JogadorResponseDTO;
import com.example.exemplodto.mapper.JogadorMapper;
import com.example.exemplodto.models.JogadorEntidade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class JogadorService {
    List<JogadorEntidade> listaJogadores = new ArrayList<>();

    @Autowired
    JogadorMapper jogadorMapper;

    public JogadorResponseDTO insereJogador(JogadorRequestDTO jogadorRequestDTO) {
        Integer habilidadeAleatoria = new Random().nextInt(0, 100);

        JogadorEntidade jogador = new JogadorEntidade();
        jogador.setNome(jogadorRequestDTO.nome());
        jogador.setApelido(jogadorRequestDTO.apelido());
        jogador.setIdade(jogadorRequestDTO.idade());
        jogador.setHabilidade(habilidadeAleatoria);

        listaJogadores.add(jogador);

        return jogadorMapper.toDto(jogador);
    }
}
