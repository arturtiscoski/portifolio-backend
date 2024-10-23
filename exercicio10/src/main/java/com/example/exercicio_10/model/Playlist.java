package com.example.exercicio_10.model;

import java.util.List;

public class Playlist {
    private String id;
    private String nome;
    private String descricao;
    private String criador;
    private List<Musica> musicas;

    public Playlist(String id, String nome, String descricao, String criador, List<Musica> musicas) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.criador = criador;
        this.musicas = musicas;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCriador() {
        return criador;
    }

    public void setCriador(String criador) {
        this.criador = criador;
    }

    public List<Musica> getMusicas() {
        return musicas;
    }

    public void setMusicas(List<Musica> musicas) {
        this.musicas = musicas;
    }
}