package com.example.exercicio_10.model;

public class Musica {
    private String id;
    private String titulo;
    private String artista;
    private String duracao;

    public Musica(String id, String titulo, String artista, String duracao) {
        this.id = id;
        this.titulo = titulo;
        this.artista = artista;
        this.duracao = duracao;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }
}