package com.renanb.fly_way_backend.exception.validator;

import com.renanb.fly_way_backend.model.TripAddress;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.server.ServerWebInputException;

@RequiredArgsConstructor
@Component
public class InputValidator {

    private final Validator validator;
    public <T> void validate(T input) {
        Errors errors = new BeanPropertyBindingResult(input, "input");
        validator.validate(input, errors);
        if (errors.hasErrors()) {
            throw new ServerWebInputException(errors.toString());
        }
    }
}
