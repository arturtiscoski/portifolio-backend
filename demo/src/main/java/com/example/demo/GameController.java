package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping
    public ResponseEntity<List<Game>> getGames() {
        List<Game> games = gameService.fetchGames();
        return ResponseEntity.ok(games);
    }

    @PostMapping("/filter")
    public ResponseEntity<List<Game>> filterGames(@RequestBody FilterCriteria criteria) {
        List<Game> filteredGames = gameService.filterGames(criteria);
        return ResponseEntity.ok(filteredGames);
    }

    @GetMapping("/sobre")
    public ResponseEntity<Map<String, String>> getSobre() {
        Map<String, String> info = new HashMap<>();
        info.put("estudante", "Artur Salvador Tiscoski");
        info.put("projeto", "Buscador de jogos");
        return ResponseEntity.ok(info);
    }
}
