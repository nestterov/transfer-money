package com.example.transfermoney.advice;

import com.example.transfermoney.exception.ErrorTransferOrConfirmException;
import com.example.transfermoney.exception.InvalidDataException;
import com.example.transfermoney.logger.LoggerImpl;
import com.example.transfermoney.logger.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.concurrent.atomic.AtomicInteger;
@RestControllerAdvice
public class ExceptionHandlerAdvice {
    Logger logger;
    AtomicInteger errorId;
    public ExceptionHandlerAdvice(){
        logger = LoggerImpl.getInstance();
        errorId = new AtomicInteger(0);
    }
    @ExceptionHandler(InvalidDataException.class)
    public ResponseEntity<ErrorResponse> handler(InvalidDataException e){
        logger.log(e.getMessage());
        return buildResponse(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(ErrorTransferOrConfirmException.class)
    public ResponseEntity<ErrorResponse> handler(ErrorTransferOrConfirmException e){
        logger.log(e.getMessage());
        return buildResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    private ResponseEntity<ErrorResponse> buildResponse( String msg, HttpStatus status){
        return switch (status) {
            case BAD_REQUEST -> new ResponseEntity<>(
                    new ErrorResponse(
                            "BAD_REQUEST : " + msg,
                            errorId.incrementAndGet()
                    ),
                    HttpStatus.BAD_REQUEST
            );
            case INTERNAL_SERVER_ERROR -> new ResponseEntity<>(
                    new ErrorResponse(
                            "INTERNAL_SERVER_ERROR : " + msg,
                            errorId.incrementAndGet()
                    ),
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
            default -> new ResponseEntity<>(
                    new ErrorResponse("BAD_GATEWAY", errorId.incrementAndGet()),
                    HttpStatus.BAD_GATEWAY
            );
        };
    }
}