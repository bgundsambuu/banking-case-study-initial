package com.example.banking.service;

import com.example.banking.module.Loan;
import com.example.banking.repo.LoanRepo;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.List;
import java.util.Optional;

@Service
public class LoanService {
    LoanRepo loanRepo;
    public LoanService(LoanRepo loanRepo) {
        this.loanRepo = loanRepo;
    }
    public Loan add(Loan loan){
        Loan result = null;
        try{
            result = loanRepo.save(loan);
        }catch (Exception e){
            return Loan.builder().withDefaultMsg("No accounts available to show currently").build();
        }
        return result;
    }
    public boolean delete(Long id){
        Optional res = loanRepo.findById(id);
        if(!res.isPresent()){
            return false;
        }
        try{
            loanRepo.delete((Loan)res.get());
        }catch (Exception e) {
            return false;
        }
        return true;
    }
    public Loan update(Long id, Loan loan){
        Optional res = loanRepo.findById(id);
        if(!res.isPresent()){
            return Loan.builder().withDefaultMsg("Couldn't find update data").build();
        }
        Loan update = (Loan)res.get();
        update.setClientId(loan.getClientId());
        update.setBalance(loan.getBalance());
        update.setName(loan.getName());
        return loanRepo.save(update);
    }
    public List<Loan> getAll(){
        return (List<Loan>)loanRepo.findAll();
    }
    public List<Loan> getLoanByClientID(String clientId){
        return this.loanRepo.findByClientId(clientId);
    }
}
