package com.example.banking.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class InitialDeposit {
    private String clientId;
    private String Name;
    private Double initialBalance;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Double getInitialBalance() {
        return initialBalance;
    }

    public void setInitialBalance(Double initialBalance) {
        this.initialBalance = initialBalance;
    }

    public static InnerInitialDepositBuilder builder(){
        return new InnerInitialDepositBuilder();
    }
    public static class InnerInitialDepositBuilder {
        InitialDeposit initialDeposit;
        public InnerInitialDepositBuilder(){
            this.initialDeposit = new InitialDeposit();
        }
        public InnerInitialDepositBuilder withClientId(String id){
            this.initialDeposit.setClientId(id);
            return this;
        }
        public InnerInitialDepositBuilder withName(String name){
            this.initialDeposit.setName(name);
            return this;
        }
        public InnerInitialDepositBuilder withBalance(Double balance){
            this.initialDeposit.setInitialBalance(balance);
            return this;
        }

        public InitialDeposit build(){
            return this.initialDeposit;
        }
    }
}
