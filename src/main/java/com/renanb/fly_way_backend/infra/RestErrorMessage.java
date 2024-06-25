package com.renanb.fly_way_backend.infra;

import lombok.*;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestErrorMessage {

    private HttpStatus httpStatus;
    private String message;

}
