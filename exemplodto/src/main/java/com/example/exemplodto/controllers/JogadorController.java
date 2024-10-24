package com.example.exemplodto.controllers;

import com.example.exemplodto.dtos.JogadorRequestDTO;
import com.example.exemplodto.dtos.JogadorResponseDTO;
import com.example.exemplodto.services.JogadorService;
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
