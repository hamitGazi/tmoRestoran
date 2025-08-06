package hamit.demir.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(value = {BaseException.class})
    public ResponseEntity<GenericRespose<String>> handleBaseExeption(BaseException ex) {

        return ResponseEntity
                .badRequest()
                .body(GenericRespose
                        .error(ex.getMessage(), HttpStatus.NOT_FOUND.toString()));

    }


}
