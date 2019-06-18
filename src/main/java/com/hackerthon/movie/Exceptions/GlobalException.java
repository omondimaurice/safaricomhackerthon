package com.hackerthon.movie.Exceptions;

import com.hackerthon.movie.util.ErrorResponseWrapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Calendar;

@ControllerAdvice
public class GlobalException {

    /**
    catches all exceptions

     **/

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseWrapper> exception(Exception e) {
        ErrorResponseWrapper errorResponseWrapper = new ErrorResponseWrapper();
        errorResponseWrapper.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        errorResponseWrapper.setTimestamp(Calendar.getInstance().getTimeInMillis());
        errorResponseWrapper.setMessage(e.getMessage());

        return new ResponseEntity<>(errorResponseWrapper,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
