package com.example.banking.service;

import com.example.banking.model.CreditCard;
import com.example.banking.repo.CreditCardRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CreditCardService {
    CreditCardRepo creditCardRepo;

    public CreditCardService(CreditCardRepo creditCardRepo) {
        this.creditCardRepo = creditCardRepo;
    }

    public CreditCard add(CreditCard creditCard) {
        CreditCard result = null;
        try{
            result = creditCardRepo.save(creditCard);
        }catch (Exception e){
            return CreditCard.builder().withDefaultMsg("No accounts available to show currently").build();
        }
        return result;
    }

    public CreditCard update(Long id, CreditCard creditCard) {
        Optional res = creditCardRepo.findById(id);
        if(!res.isPresent()){
            return CreditCard.builder().withDefaultMsg("Couldn't find the update data").build();
        }
        CreditCard update = (CreditCard) res.get();
        update.setClientId(creditCard.getClientId());
        update.setBalance(creditCard.getBalance());
        update.setName(creditCard.getName());
        update.setNumber(creditCard.getNumber());
        return creditCardRepo.save(update);
    }

    public boolean delete(Long id) {
        Optional res = creditCardRepo.findById(id);
        if(!res.isPresent()){
            return false;
        }
        try{
            creditCardRepo.delete((CreditCard) res.get());
        }catch (Exception e) {
            return false;
        }
        return true;
    }

    public List<CreditCard> getCreditCardByClientId(String id) {
        return this.creditCardRepo.findByClientId(id);
    }

    public List<CreditCard> getAll() {
        return (List<CreditCard>)creditCardRepo.findAll();
    }
}
