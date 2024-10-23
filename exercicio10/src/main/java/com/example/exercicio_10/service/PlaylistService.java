package com.example.exercicio_10.service;

import com.example.exercicio_10.model.Playlist;
import com.example.exercicio_10.model.Musica;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlaylistService {
    private List<Playlist> playlists = new ArrayList<>();

    public List<Playlist> getAllPlaylists() {
        return playlists;
    }

    public Optional<Playlist> getPlaylistById(String id) {
        return playlists.stream().filter(p -> p.getId().equals(id)).findFirst();
    }

    public Playlist createPlaylist(Playlist playlist) {
        playlists.add(playlist);
        return playlist;
    }

    public Optional<Playlist> updatePlaylist(String id, Playlist updatedPlaylist) {
        return getPlaylistById(id).map(playlist -> {
            playlist.setNome(updatedPlaylist.getNome());
            playlist.setDescricao(updatedPlaylist.getDescricao());
            return playlist;
        });
    }

    public boolean deletePlaylist(String id) {
        return playlists.removeIf(p -> p.getId().equals(id));
    }

    public Optional<Playlist> addMusicaToPlaylist(String playlistId, Musica musica) {
        return getPlaylistById(playlistId).map(playlist -> {
            playlist.getMusicas().add(musica);
            return playlist;
        });
    }

    public Optional<Playlist> removeMusicaFromPlaylist(String playlistId, String musicaId) {
        return getPlaylistById(playlistId).map(playlist -> {
            playlist.getMusicas().removeIf(musica -> musica.getId().equals(musicaId));
            return playlist;
        });
    }
}