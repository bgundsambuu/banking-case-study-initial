package com.example.banking.controller;

import com.example.banking.model.Deposit;
import com.example.banking.model.InitialDeposit;
import com.example.banking.service.DepositService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/deposit")
public class DepositController {
    DepositService depositService;

    public DepositController(DepositService depositService) {
        this.depositService = depositService;
    }

    @PostMapping(value = "/createDepositAccount", produces = "application/json")
    public Deposit createDepositAccount(@RequestBody InitialDeposit initialDeposit){
        return depositService.add(initialDeposit);
    }

    @PutMapping(value = "/updateDepositAccount/{id}", produces = "application/json")
    public Deposit updateDepositAccount(@PathVariable("id") Long id, @RequestBody Deposit deposit){
        Deposit res = depositService.update(id, deposit);
        return res;
    }

    @DeleteMapping(value = "/deleteDepositAccount/{id}", produces = "application/json")
    public ResponseEntity deleteDepositAccount(@PathVariable("id") Long id){
        if(!depositService.delete(id)){
            return new ResponseEntity("Record not deleted.", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/getDepositAccountsByClientId/{clientId}")
    public List<Deposit> getDepositAccountsByClientId(@PathVariable("clientId") String id){
        return depositService.getCreditCardByClientId(id);
    }

    @GetMapping("/getAllDepositAccounts")
    public List<Deposit> getAllDepositAccounts(){
        return depositService.getAll();
    }
}
