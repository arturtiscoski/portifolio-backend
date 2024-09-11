package com.example.exercicio07;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IngressoController {
    private Cinema cinema = new Cinema();

    @GetMapping("/venderIngresso")
    public String venderIngresso(
            @RequestParam String nomeCliente,
            @RequestParam int idadeCliente,
            @RequestParam String nomeFilme,
            @RequestParam String assento) {
        try {
            Cliente cliente = new Cliente(nomeCliente, idadeCliente);
            Filme filme = cinema.encontrarFilme(nomeFilme);
            cinema.venderIngresso(cliente, filme, assento);
            return "Ingresso vendido com sucesso! " + filme.getNome() + " - " + assento + " - " + nomeCliente;
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
