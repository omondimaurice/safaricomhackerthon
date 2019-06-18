package com.hackerthon.movie.util;

import lombok.Data;

@Data
public class MovieResponseWrapper<T> {
    private int statusCode;
    private String message;
    private T data;
}
