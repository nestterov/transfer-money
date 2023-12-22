package com.example.transfermoney.model;

public class OperationResponse {
    private String operationId;
    public OperationResponse(String operationId){
        this.operationId = operationId;
    }
    public OperationResponse(){
    }
    public String getOperationId(){
        return operationId;
    }
    public void setOperationId(String operationId){
        this.operationId = operationId;
    }
}