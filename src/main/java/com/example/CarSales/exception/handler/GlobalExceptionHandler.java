package com.example.CarSales.exception.handler;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CommonException.class)
    public ResponseEntity<ErrorDetails> handleUserNotExistsException(CommonException exception) {
        ErrorDetails errorDetails = new ErrorDetails(exception.getCode(), exception.getDestriction());
        return ResponseEntity.status(exception.getHttpStatusCode()).body(errorDetails);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails>handleInternalServerError(Exception exception){
        exception.printStackTrace();
        ErrorDetails errorDetails= new ErrorDetails("5500", exception.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(errorDetails);
    }
}


//    @ExceptionHandler(UserNotExistsException.class)
//    public ResponseEntity<ErrorDetails> handleUserNotExistsException(UserNotExistsException userNotExistsException){
//        ErrorDetails errorDetails= new ErrorDetails("10000", "user not exists");
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDetails);
//    }
//    @ExceptionHandler(PasswordsNotMatchedException.class)
//    public ResponseEntity<ErrorDetails> handlePasswordsNotMatchedException(PasswordsNotMatchedException passwordsNotMatchedException){
//        ErrorDetails errorDetails= new ErrorDetails("10001", "password is not true");
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDetails);
//    }

