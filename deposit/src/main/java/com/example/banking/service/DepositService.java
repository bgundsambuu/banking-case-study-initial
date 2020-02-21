package com.example.banking.service;

import com.example.banking.model.Deposit;
import com.example.banking.model.InitialDeposit;
import com.example.banking.repo.DepositRepo;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class DepositService {
    DepositRepo depositRepo;

    public DepositService(DepositRepo depositRepo) {
        this.depositRepo = depositRepo;
    }

    public Deposit add(InitialDeposit initialDeposit) {
        int number = (int)(Math.random()*((999999999-100000000)+1))+100000000;
        List<Deposit> deposits = (List<Deposit>)depositRepo.findAll();
        Set<String> accNum = new HashSet<>();
        deposits.forEach(dep->{
            accNum.add(dep.getAccountNumber());
        });
        while(true){
            if(!accNum.contains(number+"")) break;
            number = (int)(Math.random()*((999999999-100000000)+1))+100000000;
        }
        Deposit newDeposit = Deposit.builder().withAccountNumber(number+"")
                .withBalance(initialDeposit.getInitialBalance())
                .withClientId(initialDeposit.getClientId())
                .withName(initialDeposit.getName())
                .build();
        return depositRepo.save(newDeposit);
    }

    public Deposit update(Long id, Deposit deposit) {
        Optional res = depositRepo.findById(id);
        if(!res.isPresent()){
            return Deposit.builder().withDefaultMsg("Couldn't find the update data").build();
        }
        Deposit update = (Deposit) res.get();
        Double balance = deposit.getBalance()!=null ? deposit.getBalance() : update.getBalance();
        update.setClientId(deposit.getClientId());
        update.setBalance(deposit.getBalance());
        update.setName(deposit.getName());
        update.setBalance(balance);
        return depositRepo.save(update);
    }

    public boolean delete(Long id) {
        Optional res = depositRepo.findById(id);
        if(!res.isPresent()){
            return false;
        }
        try{
            depositRepo.delete((Deposit) res.get());
        }catch (Exception e) {
            return false;
        }
        return true;
    }

    public List<Deposit> getCreditCardByClientId(String id) {
        return this.depositRepo.findByClientId(id);
    }

    public List<Deposit> getAll() {
        return (List<Deposit>)depositRepo.findAll();
    }
}
