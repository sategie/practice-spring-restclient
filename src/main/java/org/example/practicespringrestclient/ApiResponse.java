package org.example.practicespringrestclient;

import java.util.List;

public record ApiResponse(
//        The list has to be called results, since the external api is also named results
        List<ApiResponseFields> results
) {
}
