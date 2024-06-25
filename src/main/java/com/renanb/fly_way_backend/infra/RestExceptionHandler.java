package com.renanb.fly_way_backend.infra;

import com.renanb.fly_way_backend.exception.ZipCodeOutOfPatternException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.reactive.result.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ZipCodeOutOfPatternException.class)
    private ResponseEntity<RestErrorMessage> zipCodeOutOfPatternHandler(ZipCodeOutOfPatternException exception){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new RestErrorMessage(HttpStatus.BAD_REQUEST, exception.getMessage()));
    }
}
