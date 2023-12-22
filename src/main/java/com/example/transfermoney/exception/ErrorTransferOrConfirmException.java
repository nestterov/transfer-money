package com.example.transfermoney.exception;

public class ErrorTransferOrConfirmException extends RuntimeException{
    public ErrorTransferOrConfirmException(String msg){
        super(msg);
    }
}