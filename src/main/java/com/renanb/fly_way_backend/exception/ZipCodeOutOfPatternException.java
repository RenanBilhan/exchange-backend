package com.renanb.fly_way_backend.exception;

public class ZipCodeOutOfPatternException extends RuntimeException {
    public ZipCodeOutOfPatternException(){
        super("Zip code out of pattern.");
    }
}
