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
//        No need to use the 'this' keyword here because final fields must be initialized during object creation
//        This is already happening here by assigning the builder argument to the final field restClient
//        In addition, this assignment is only happening once within the constructor
        restClient = builder
                .baseUrl("https://rickandmortyapi.com/api")
                .build();

    }

    /*
    * Retrieves a list of characters from the Rick and Morty API
    *
    * @return A list of ApiResponseFields objects*/
    public List<ApiResponseFields> findAll(){
//        Perform a GET request to the "/character" endpoint
        return restClient.get()

                .uri("/character")
                .retrieve()
                .body(ApiResponse.class)
                .results();

    }

/*
* Retrieves a single character from the Rick and Morty API by its id
* */
    public ApiResponseFields findById(int id){
        return restClient.get()
                .uri("/character/{id}", id)
                .retrieve()
                .body(ApiResponseFields.class);
    }

}
