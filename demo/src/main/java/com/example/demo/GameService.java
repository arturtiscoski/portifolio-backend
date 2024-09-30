package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameService {

    private final String CHEAPSHARK_API_URL = "https://www.cheapshark.com/api/1.0/deals";

    public List<Game> fetchGames() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Game[]> response = restTemplate.getForEntity(CHEAPSHARK_API_URL, Game[].class);

        return Arrays.asList(response.getBody());
    }

    public List<Game> filterGames(FilterCriteria criteria) {
        List<Game> games = fetchGames();
        return games.stream()
                .filter(game -> game.getSalePrice() <= criteria.getMaxPrice())
                .collect(Collectors.toList());
    }
}
