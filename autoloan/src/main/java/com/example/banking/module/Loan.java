package com.example.banking.module;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import com.google.gson.Gson;

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String clientId;
    private String name;
    private Double balance;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
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

    public static InnerLoanBuilder builder(){
        return new InnerLoanBuilder();
    }
    public static class InnerLoanBuilder{
        Loan loan;

        public InnerLoanBuilder() {
            this.loan = new Loan();
        }
        public InnerLoanBuilder withClientId(String clientId){
            loan.setClientId(clientId);
            return this;
        }
        public InnerLoanBuilder withName(String name){
            loan.setName(name);
            return this;
        }
        public InnerLoanBuilder withBalance(Double balance){
            loan.setBalance(balance);
            return this;
        }
        public InnerLoanBuilder withDefaultMsg(String msg){
            loan.setDefaultMessage(msg);
            return this;
        }
        public Loan build(){
            return this.loan;
        }
    }
}
