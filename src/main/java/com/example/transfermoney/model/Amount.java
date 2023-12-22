package com.example.transfermoney.model;

public class Amount {
    private Currency currency;
    private Float value;
    public Amount(){
    }
    public Amount(Currency currency, Long value){
        this.currency = currency;
        this.value = (float) (value / 100);
    }
    public Currency getCurrency(){
        return currency;
    }
    public void setCurrency(Currency currency){
        this.currency = currency;
    }
    public Float getValue(){
        return value;
    }
    public void setValue(Long value){
        this.value = (float) (value / 100);
    }
    @Override
    public String toString(){
        return value + " " + currency.name();
    }
}