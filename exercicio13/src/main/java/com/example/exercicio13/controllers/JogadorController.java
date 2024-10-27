package com.example.exercicio13.controllers;

import com.example.exercicio13.dtos.JogadorRequestDTO;
import com.example.exercicio13.dtos.JogadorResponseDTO;
import com.example.exercicio13.services.JogadorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JogadorController {
    @Autowired
    JogadorService jogadorService;

    @PostMapping("/jogadores")
    @ResponseBody
    public JogadorResponseDTO insereJogador(@RequestBody @Valid JogadorRequestDTO jogadorRequestDTO) {
        return jogadorService.insereJogador(jogadorRequestDTO);
    }

    @GetMapping("/jogadores")
    @ResponseBody
    public List<JogadorResponseDTO> listaJogadores() {
        return jogadorService.retornaJogadores();
    }
}
