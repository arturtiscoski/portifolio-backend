package com.example.exercicio11.controllers;

import com.example.exercicio11.dtos.TransacaoRequestDTO;
import com.example.exercicio11.dtos.TransacaoResponseDTO;
import com.example.exercicio11.services.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

    @Autowired
    private TransacaoService transacaoService;

    @Autowired
    public TransacaoController(TransacaoService transacoesService) {
        this.transacaoService = transacoesService;
    }

    @PostMapping("/gerar")
    public ResponseEntity<TransacaoResponseDTO> gerarTransacao(@RequestBody TransacaoRequestDTO request) {
        try {
            TransacaoResponseDTO response = transacaoService.criarTransacao(request);
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}

