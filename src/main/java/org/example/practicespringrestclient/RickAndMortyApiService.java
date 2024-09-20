package org.example.practicespringrestclient;


import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class RickAndMortyApiService {
    private final RestClient restClient;


    /*
    * Constructor to initialize the class with the static nested class RestClient.Builder
    * builder is used to configure(build) the restClient instance
    * */
    public RickAndMortyApiService(RestClient.Builder builder){
        this.restClient = builder
                .baseUrl("https://rickandmortyapi.com/api")
                .build();

    }


    public List<ApiResponseFields> findAll(){
        ApiResponse response = this.restClient.get()
        .uri("/character")
                .retrieve()
                .body(ApiResponse.class);
        return response.results();


    }


}
