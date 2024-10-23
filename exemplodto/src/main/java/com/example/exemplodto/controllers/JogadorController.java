package com.example.exemplodto.controllers;

import com.example.exemplodto.dtos.JogadorRequestDTO;
import com.example.exemplodto.dtos.JogadorResponseDTO;
import com.example.exemplodto.services.JogadorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JogadorController {
    @Autowired
    JogadorService jogadorService;

    @PostMapping("/jogadores")
    @ResponseBody
    public JogadorResponseDTO insereJogador(@RequestBody @Valid JogadorRequestDTO jogadorRequestDTO) {
        return jogadorService.insereJogador(jogadorRequestDTO);
    }
}
