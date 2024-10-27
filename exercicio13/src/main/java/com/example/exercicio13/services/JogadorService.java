package com.example.exercicio13.services;

import com.example.exercicio13.dtos.JogadorRequestDTO;
import com.example.exercicio13.dtos.JogadorResponseDTO;
import com.example.exercicio13.mapper.JogadorMapper;
import com.example.exercicio13.models.JogadorEntidade;
import com.example.exercicio13.repositories.JogadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class JogadorService {
    @Autowired
    JogadorRepository jogadorRepository;

    @Autowired
    JogadorMapper jogadorMapper;

    public JogadorResponseDTO insereJogador(JogadorRequestDTO jogadorRequestDTO) {
        Integer habilidadeAleatoria = new Random().nextInt(0, 100);

        JogadorEntidade jogador = new JogadorEntidade();
        jogador.setNome(jogadorRequestDTO.nome());
        jogador.setApelido(jogadorRequestDTO.apelido());
        jogador.setIdade(jogadorRequestDTO.idade());
        jogador.setHabilidade(habilidadeAleatoria);

        jogadorRepository.save(jogador);

        return jogadorMapper.toDto(jogador);
    }

    public List<JogadorResponseDTO> retornaJogadores () {
        return jogadorRepository.findAll().stream().map(jogadorMapper::toDto).toList();
    }
}
