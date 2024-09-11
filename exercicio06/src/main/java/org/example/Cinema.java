package org.example;

import java.util.ArrayList;
import java.util.List;

public class Cinema {
    private List<Filme> filmesDisponiveis;
    private List<Ingresso> ingressosVendidos;
    private List<String> assentosOcupados;

    public Cinema() {
        filmesDisponiveis = new ArrayList<>();
        ingressosVendidos = new ArrayList<>();
        assentosOcupados = new ArrayList<>();
    }

    public void inicializarFilmes() {
        filmesDisponiveis.add(new Filme("Homen Aranha", 20.0, 12));
        filmesDisponiveis.add(new Filme("Batman", 22.5, 14));
        filmesDisponiveis.add(new Filme("Matrix", 18.0, 16));
        filmesDisponiveis.add(new Filme("Frozen", 15.0, 0));
        filmesDisponiveis.add(new Filme("Avatar", 25.0, 13));
    }

    public Filme encontrarFilme(String nome) throws Exception {
        return filmesDisponiveis.stream()
                .filter(filme -> filme.getNome().equalsIgnoreCase(nome))
                .findFirst()
                .orElseThrow(() -> new Exception("Filme não encontrado!"));
    }

    public void venderIngresso(Cliente cliente, Filme filme, String assento) throws Exception {
        if (cliente.getIdade() < filme.getIdadeMinima()) {
            throw new Exception("O ingresso não pode ser vendido pois sua idade não permite!");
        }
        if (assentosOcupados.contains(assento)) {
            throw new Exception("O ingresso não pode ser vendido pois seu assento não está mais disponível!");
        }

        Ingresso ingresso = new Ingresso(cliente, filme, assento);
        ingressosVendidos.add(ingresso);
        assentosOcupados.add(assento);
        System.out.println(ingresso);
    }
}
