package com.hackerthon.movie.util;

import lombok.Data;

@Data
public class ErrorResponseWrapper<T> {
    public int statusCode;
    public T message;
    public Long timestamp;
}
