package com.example.exercicio_10.controller;

import com.example.exercicio_10.model.Playlist;
import com.example.exercicio_10.model.Musica;
import com.example.exercicio_10.service.PlaylistService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/playlists")
public class PlaylistController {

    private final PlaylistService playlistService;

    public PlaylistController(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @GetMapping
    public List<Playlist> getAllPlaylists() {
        return playlistService.getAllPlaylists();
    }

    @GetMapping("/{playlistId}")
    public ResponseEntity<Playlist> getPlaylistById(@PathVariable String playlistId) {
        Optional<Playlist> playlist = playlistService.getPlaylistById(playlistId);
        return playlist.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Playlist> createPlaylist(@RequestBody Playlist playlist) {
        Playlist createdPlaylist = playlistService.createPlaylist(playlist);
        return ResponseEntity.status(201).body(createdPlaylist);
    }

    @PutMapping("/{playlistId}")
    public ResponseEntity<Playlist> updatePlaylist(@PathVariable String playlistId, @RequestBody Playlist playlist) {
        Optional<Playlist> updatedPlaylist = playlistService.updatePlaylist(playlistId, playlist);
        return updatedPlaylist.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{playlistId}")
    public ResponseEntity<Void> deletePlaylist(@PathVariable String playlistId) {
        if (playlistService.deletePlaylist(playlistId)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{playlistId}/musicas")
    public ResponseEntity<Playlist> addMusicaToPlaylist(@PathVariable String playlistId, @RequestBody Musica musica) {
        Optional<Playlist> updatedPlaylist = playlistService.addMusicaToPlaylist(playlistId, musica);
        return updatedPlaylist.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{playlistId}/musicas/{musicaId}")
    public ResponseEntity<Playlist> removeMusicaFromPlaylist(@PathVariable String playlistId, @PathVariable String musicaId) {
        Optional<Playlist> updatedPlaylist = playlistService.removeMusicaFromPlaylist(playlistId, musicaId);
        return updatedPlaylist.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}