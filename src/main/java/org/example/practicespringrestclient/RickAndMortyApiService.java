package org.example.practicespringrestclient;


import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class RickAndMortyApiService {
    private final RestClient restClient;


    /*
    * Constructor to initialize the class using the static nested class RestClient.Builder
    * builder(can be named anything) is used to configure(build) the restClient instance
    * */
    public RickAndMortyApiService(RestClient.Builder builder){
        this.restClient = builder
                .baseUrl("https://rickandmortyapi.com/api")
                .build();

    }


    /*
    * Retrieves a list of characters from the Rick and Morty API
    *
    * @return A list of ApiResponseFields objects*/
    public List<ApiResponseFields> findAll(){
//        Perform a GET request to the "/character" endpoint
        ApiResponse response = this.restClient.get()
        .uri("/character")
                .retrieve()
                .body(ApiResponse.class);
        return response.results();

    }


}
