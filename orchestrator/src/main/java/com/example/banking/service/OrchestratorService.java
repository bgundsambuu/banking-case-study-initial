package com.example.banking.service;

import com.example.banking.resClient.RestClient;
import org.springframework.stereotype.Service;

@Service
public class OrchestratorService {
    RestClient restClient;

    public OrchestratorService(RestClient restClient) {
        this.restClient = restClient;
    }
    public String getAccountSummaryOfDeposit(String clientId){

        String accSumOfLoan = restClient.getLoanSummary(clientId);
        String accSumOfCreditcard = restClient.getCreditCardSummary(clientId);
        String accSumOfDeposit = restClient.getAccDepositSummary(clientId);

        StringBuilder sb = new StringBuilder();
        sb.append(accSumOfLoan).append("\n")
                .append(accSumOfCreditcard).append("\n")
                .append(accSumOfDeposit);
        return sb.toString();
    }
}
