package com.example.transfermoney.controller;

import com.example.transfermoney.exception.ErrorTransferOrConfirmException;
import com.example.transfermoney.model.ConfirmInfo;
import com.example.transfermoney.model.OperationResponse;
import com.example.transfermoney.model.Transfer;
import com.example.transfermoney.repository.TransferRepository;
import com.example.transfermoney.service.TransferService;
import org.springframework.web.bind.annotation.*;
@RestController()
@CrossOrigin(origins = "https://serp-ya.github.io/card-transfer/", allowedHeaders = "*")
public class TransferController{
    private TransferService transferService;
    public TransferController(){
        TransferRepository repository = new TransferRepository();
        this.transferService = new TransferService(repository);
    }
    @PostMapping("transfer")
    public OperationResponse doTransfer(@RequestBody Transfer transfer){
        return transferService.doTransfer(transfer);
    }
    @PostMapping("confirmOperation")
    public OperationResponse confirmOperation(@RequestBody ConfirmInfo info){
        return transferService.confirmOperation(info);
    }
}