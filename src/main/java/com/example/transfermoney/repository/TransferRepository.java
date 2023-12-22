package com.example.transfermoney.repository;

import com.example.transfermoney.model.Transfer;
import org.springframework.stereotype.Repository;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
@Repository
public class TransferRepository{
    private ConcurrentMap<String, TransferState> transferStateMap;
    private ConcurrentMap<String, Transfer> transferList;
    private AtomicInteger id;
    public TransferRepository(){
        this.transferStateMap = new ConcurrentHashMap<>();
        this.transferList = new ConcurrentHashMap<>();
        id = new AtomicInteger(0);
    }
    public String addTransfer(Transfer transfer){
        String transferId = id.incrementAndGet() + "";
        transferStateMap.put(transferId + "", TransferState.LOAD);
        transferList.put(transferId + "", transfer);
        return transferId;
    }
    public Transfer confirmOperation(String id){
        if(!transferStateMap.containsKey(id)){
            return null;
        }
        transferStateMap.put(id, TransferState.OK);
        return transferList.get(id);
    }
    public Transfer errorConfirmOperation(String id){
        if(!transferStateMap.containsKey(id)){
            return null;
        }
        transferStateMap.put(id, TransferState.ERROR);
        return transferList.get(id);
    }
    public TransferState getTransferState(String id){
        return transferStateMap.get(id);
    }
}