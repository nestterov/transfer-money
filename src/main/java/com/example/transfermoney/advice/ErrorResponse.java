package com.example.transfermoney.advice;

public class ErrorResponse {
    private String message;
    private Integer Id;
    public ErrorResponse(String message, Integer id){
        this.message = message;
        Id = id;
    }
    public ErrorResponse(){
    }
    public String getMessage(){
        return message;
    }
    public void setMessage(String message){
        this.message = message;
    }
    public Integer getId(){
        return Id;
    }
    public void setId(Integer id){
        Id = id;
    }
}