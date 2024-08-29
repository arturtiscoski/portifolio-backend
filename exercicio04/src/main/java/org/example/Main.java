package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MusicCloud musicCloud = new MusicCloud();
        Scanner scanner = new Scanner(System.in);
        Playlist playlist = new Playlist();

        System.out.println("Insira o nome da playlist -> ");
        String nomePlaylist = scanner.nextLine();
        playlist.setNome(nomePlaylist);

        boolean continuar = true;

        while (continuar) {
            System.out.println("Insira o nome da música -> ");
            String nomeMusica = scanner.nextLine();

            if (nomeMusica.isEmpty()) continuar = false;

            try {
                playlist.adicionarMusica(musicCloud.buscarMusica(nomeMusica));
                System.out.println("Você adicionou a música " + nomeMusica + " na playlist.");
            } catch (RuntimeException exception) {
                System.out.println(exception.getMessage());
            }
        }

        System.out.println("Sua playlist de nome " + playlist.getNome());
        ArrayList<Musica> musicas = playlist.getMusicas();

        for (Musica musicaAtual: musicas) {
            System.out.println(" -> " + musicaAtual.getTitulo() + " do(a) -> " + musicaAtual.getArtista());
        }
    }
}