package com.example.banking.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String clientId;
    private String number;
    private String name;
    private Double Balance;
    private String defaultMessage;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getBalance() {
        return Balance;
    }

    public void setBalance(Double balance) {
        Balance = balance;
    }

    public String getDefaultMessage() {
        return defaultMessage;
    }

    public void setDefaultMessage(String defaultMessage) {
        this.defaultMessage = defaultMessage;
    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    public static InnerCreditCardBuilder builder(){
        return new InnerCreditCardBuilder();
    }

    public static class InnerCreditCardBuilder{
        CreditCard creditCard;

        public InnerCreditCardBuilder() {
            this.creditCard = new CreditCard();
        }

        public InnerCreditCardBuilder withClientId(String clientId){
            creditCard.setClientId(clientId);
            return this;
        }
        public InnerCreditCardBuilder withNumber(String number){
            creditCard.setNumber(number);
            return this;
        }
        public InnerCreditCardBuilder withName(String name){
            creditCard.setName(name);
            return this;
        }
        public InnerCreditCardBuilder withBalance(Double balance){
            creditCard.setBalance(balance);
            return this;
        }
        public InnerCreditCardBuilder withDefaultMsg(String msg){
            creditCard.setDefaultMessage(msg);
            return this;
        }
        public CreditCard build(){
            return this.creditCard;
        }
    }
}
