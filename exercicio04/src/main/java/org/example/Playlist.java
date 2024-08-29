package org.example;

import java.util.ArrayList;

public class Playlist {
    private String nome;
    private ArrayList<Musica> musicas = new ArrayList<Musica>();

    public void adicionarMusica(Musica musica) {
        this.musicas.add(musica);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Musica> getMusicas() {
        return musicas;
    }

    public void setMusicas(ArrayList<Musica> musicas) {
        this.musicas = musicas;
    }
}
