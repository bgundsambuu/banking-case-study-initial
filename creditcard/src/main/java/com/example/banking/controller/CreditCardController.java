package com.example.banking.controller;

import com.example.banking.model.CreditCard;
import com.example.banking.service.CreditCardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/creditcard")
public class CreditCardController {
    CreditCardService creditCardService;

    public CreditCardController(CreditCardService creditCardService) {
        this.creditCardService = creditCardService;
    }

    @PostMapping(value = "/createCreditCard", produces = "application/json")
    public CreditCard createCreditCard(@RequestBody CreditCard creditCard){
        return creditCardService.add(creditCard);
    }

    @PutMapping(value = "/updateCreditCard/{id}", produces = "application/json")
    public CreditCard modifyCreditCard(@PathVariable("id") Long id, @RequestBody CreditCard creditCard){
        CreditCard res = creditCardService.update(id, creditCard);
        return res;
    }

    @DeleteMapping(value = "/deleteCreditCard/{id}", produces = "application/json")
    public ResponseEntity deleteCreditCard(@PathVariable("id") Long id){
        if(!creditCardService.delete(id)){
            return new ResponseEntity("Record not deleted.", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/getCreditCardsByClientId/{clientId}")
    public List<CreditCard> getCreditCardByClientId(@PathVariable("clientId") String id){
        return creditCardService.getCreditCardByClientId(id);
    }

    @GetMapping("/getAllCreditCards")
    public List<CreditCard> getAllCreditCards(){
        return creditCardService.getAll();
    }
}
