package com.example.transfermoney.model;

public class ConfirmInfo {
    private String code;
    private String operationId;
    public ConfirmInfo(String code, String operationId){
        this.code = code;
        this.operationId = operationId;
    }
    public ConfirmInfo(){
    }
    public String getCode(){
        return code;
    }
    public void setCode(String code){
        this.code = code;
    }
    public String getOperationId(){
        return operationId;
    }
    public void setOperationId(String operationId){
        this.operationId = operationId;
    }
    @Override
    public String toString(){
        return "code: " + code +
                "/ operationId: " + operationId;
    }
}