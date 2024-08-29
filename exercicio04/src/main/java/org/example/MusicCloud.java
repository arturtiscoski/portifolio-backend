package org.example;

import java.util.ArrayList;

public class MusicCloud {
    private ArrayList<Musica> musicasDisponiveis = new ArrayList<Musica>();

    public MusicCloud() {
        ArrayList<Musica> musicasPadrao = new ArrayList<Musica>();

        musicasPadrao.add(new Musica("Baby Shark", "Pinkfong"));
        musicasPadrao.add(new Musica("Lonely", "Imagine Dragons"));
        musicasPadrao.add(new Musica("Overcompensate", "Twenty one pilots"));
        musicasPadrao.add(new Musica("Venom", "Eminem"));
        musicasPadrao.add(new Musica("What You Know", "Two Door Cinema Club"));

        this.musicasDisponiveis = musicasPadrao;
    }

    public Musica buscarMusica(String titulo) {
        for (Musica musicaDaVez: musicasDisponiveis) {
            if (musicaDaVez.getTitulo().equals(titulo)) {
                return musicaDaVez;
            }
        }

        throw new RuntimeException("A música " + titulo + " não foi encontrada na lista de músicas disponíveis!");
    }
}
