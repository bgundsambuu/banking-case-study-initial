package com.example.banking.controller;

import com.example.banking.module.Loan;
import com.example.banking.service.LoanService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autoloan")
public class LoanController {
    LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @PostMapping(value = "/createLoan", produces = "application/json")
    public Loan createLoan(@RequestBody Loan loan){
        return loanService.add(loan);
    }
    @PutMapping(value = "/updateLoan/{id}", produces = "application/json")
    public Loan modifyLoan(@PathVariable("id") Long id, @RequestBody Loan loan){
        Loan res = loanService.update(id, loan);
        return res;
    }
    @DeleteMapping(value = "/deleteLoan/{id}", produces = "application/json")
    public ResponseEntity deleteLoan(@PathVariable("id") Long id){
        if(!loanService.delete(id)){
            return new ResponseEntity("Record not deleted.", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/getLoansByClientId/{clientId}")
    public List<Loan> getLoanByClientId(@PathVariable("clientId") String id){
        return loanService.getLoanByClientID(id);
    }
    @GetMapping("/getAllLoans")
    public List<Loan> getAllLoans(){
        return loanService.getAll();
    }
}
