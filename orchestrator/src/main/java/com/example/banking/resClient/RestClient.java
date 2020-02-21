package com.example.banking.resClient;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestClient {
    RestTemplate restTemplate;
    private String statusMsg = "{\n\tNo accounts available to show currently\n}";
    public RestClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    public String getLoanSummary(String clientId) {
        final String url = "http://localhost:9091/autoloan/getLoansByClientId/"+clientId;
        String result = restTemplate.getForObject(url, String.class);
        return result.equals("[ ]")  ? statusMsg : result;
    }
    public String getCreditCardSummary(String clientId) {
        final String url = "http://localhost:9092/creditcard/getCreditCardsByClientId/"+clientId;
        String result = restTemplate.getForObject(url, String.class);
        return result.equals("[ ]")  ? statusMsg : result;
    }
    public String getAccDepositSummary(String clientId) {
        StringBuilder sb = new StringBuilder();
        final String url = "http://localhost:9093/deposit/getDepositAccountsByClientId/"+clientId;
        String result = restTemplate.getForObject(url, String.class);
        System.out.println(result);
        return result.equals("[ ]") ? statusMsg : result;
    }
}
