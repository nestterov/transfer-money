package com.example.transfermoney.model;

import lombok.Getter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Objects;
@Getter
public class Transfer {
    private Amount amount;
    private String cardFromCVV;
    private String cardFromNumber;
    private String cardFromValidTill;
    private String cardToNumber;
    private String date;
    private String time;

    public void setDate(String date){
        this.date = date;
    }

    public void setTime(String time){
        this.time = time;
    }
    public Transfer(){
    }
    public Transfer(Amount amount, String cardFromCVV, String cardFromNumber, String cardFromValidTill, String cardToNumber){
        this.amount = amount;
        this.cardFromCVV = cardFromCVV;
        this.cardFromNumber = cardFromNumber;
        this.cardFromValidTill = cardFromValidTill;
        this.cardToNumber = cardToNumber;
    }

    public void setAmount(Amount amount){
        this.amount = amount;
    }

    public void setCardFromCVV(String cardFromCVV){
        this.cardFromCVV = cardFromCVV;
    }

    public void setCardFromNumber(String cardFromNumber){
        this.cardFromNumber = cardFromNumber;
    }

    public void setCardFromValidTill(String cardFromValidTill){
        this.cardFromValidTill = cardFromValidTill;
    }

    public void setCardToNumber(String cardToNumber){
        this.cardToNumber = cardToNumber;
    }
    @Override
    public String toString(){
        return "Transfer -> " +
                " amount: " + amount.toString() +
                "/ cardFromNumber: " + cardFromNumber  +
                "/ cardToNumber: " + cardToNumber;
    }
    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (!(o instanceof Transfer transfer)) return false;
        return Objects.equals(amount, transfer.amount) && Objects.equals(cardFromCVV, transfer.cardFromCVV) && Objects.equals(cardFromNumber, transfer.cardFromNumber) && Objects.equals(cardFromValidTill, transfer.cardFromValidTill) && Objects.equals(cardToNumber, transfer.cardToNumber) && Objects.equals(date, transfer.date) && Objects.equals(time, transfer.time);
    }
    @Override
    public int hashCode(){
        return Objects.hash(amount, cardFromCVV, cardFromNumber, cardFromValidTill, cardToNumber, date, time);
    }
}