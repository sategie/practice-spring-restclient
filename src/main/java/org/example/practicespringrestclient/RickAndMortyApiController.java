package org.example.practicespringrestclient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/character")
public class RickAndMortyApiController {
    private final RickAndMortyApiService rickAndMortyApiService;


    public RickAndMortyApiController(RickAndMortyApiService rickAndMortyApiService) {
        this.rickAndMortyApiService = rickAndMortyApiService;
    }

    @GetMapping
    public List<Character> getCharacters() {
        return rickAndMortyApiService.findAll();
    }
}
