package org.example.practicespringrestclient;

import java.util.List;

/*
* This record is what will be used in the findAll() method in the Service class */
public record ApiResponse(
//        The list has to be called results, since the external api is also named results
        List<ApiFields> results
) {
}
