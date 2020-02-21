package com.example.banking.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Deposit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String clientId;
    private String accountNumber;
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

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
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
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public void setDefaultMessage(String defaultMessage) {
        this.defaultMessage = defaultMessage;
    }

    @Override
    public String toString() {
        return "Deposit{" +
                "id=" + id +
                ", clientId='" + clientId + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                ", defaultMessage='" + defaultMessage + '\'' +
                '}';
    }

    public static InnerDepositBuilder builder(){
        return new InnerDepositBuilder();
    }
    public static class InnerDepositBuilder {
        Deposit deposit;
        public InnerDepositBuilder(){
            this.deposit = new Deposit();
        }
        public InnerDepositBuilder withClientId(String id){
            this.deposit.setClientId(id);
            return this;
        }
        public InnerDepositBuilder withAccountNumber(String accNum){
            this.deposit.setAccountNumber(accNum);
            return this;
        }
        public InnerDepositBuilder withName(String name){
            this.deposit.setName(name);
            return this;
        }
        public InnerDepositBuilder withBalance(Double balance){
            this.deposit.setBalance(balance);
            return this;
        }
        public InnerDepositBuilder withDefaultMsg(String msg){
            this.deposit.setDefaultMessage(msg);
            return this;
        }
        public Deposit build(){
            return this.deposit;
        }
    }
}
