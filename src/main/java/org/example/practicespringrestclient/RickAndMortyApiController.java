package org.example.practicespringrestclient;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/character")
public class RickAndMortyApiController {
    private final RickAndMortyApiService rickAndMortyApiService;


    public RickAndMortyApiController(RickAndMortyApiService rickAndMortyApiService) {
        this.rickAndMortyApiService = rickAndMortyApiService;
    }

    @GetMapping
    public List<ApiResponseFields> getCharacters() {
        return rickAndMortyApiService.findAll();
    }

    @GetMapping("/{id}")
    /*
    * Get a single character by its id
    * */
    public ApiResponseFields getCharacterById(@PathVariable int id) {
        return rickAndMortyApiService.findById(id);
    }

//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public ApiResponseFields createCharacter(@RequestBody ApiResponseFields character) {
//        return RickAndMortyApiService.createCharacter(ApiResponseFields);
//    }
}
