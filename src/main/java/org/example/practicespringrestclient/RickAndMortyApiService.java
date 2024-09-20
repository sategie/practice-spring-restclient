package org.example.practicespringrestclient;


import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class RickAndMortyApiService {
    private final RestClient restClient;


    /*
    * Constructor to initialize the class with a built-in RestClient.Builder
    * builder is used to configure(build) the restClient instance
    * */
    public RickAndMortyApiService(RestClient.Builder builder){
        this.restClient = builder
                .baseUrl("https://rickandmortyapi.com/api")
                .build();

    }

    /*
    * Retrieves a list of all characters from the external API in JSON format
    * Returns a list of Character objects*/
    public List<Character> findAll(){
        return restClient.get()
        .uri("/character")
                .retrieve()
//                Specifies the expected response type as a list of Character objects
                .body(new ParameterizedTypeReference<List<Character>>() {
                });

    }


}
