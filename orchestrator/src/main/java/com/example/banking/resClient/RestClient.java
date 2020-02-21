package com.example.banking.resClient;

import com.google.gson.Gson;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class RestClient {
    RestTemplate restTemplate;
    private String statusMsg = "No accounts available to show currently";
    Gson g = new Gson();
    public RestClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    public String getLoanSummary(String clientId) {
        final String url = "http://localhost:9091/autoloan/getLoansByClientId/"+clientId;
        String result = restTemplate.getForObject(url, String.class);
        Gson g = new Gson();
        String res = g.toJson(statusMsg);
        return result.equals("[ ]")  ? res : result;
    }
    public String getCreditCardSummary(String clientId) {
        final String url = "http://localhost:9092/creditcard/getCreditCardsByClientId/"+clientId;
        String result = restTemplate.getForObject(url, String.class);
        String res = g.toJson(statusMsg);
        return result.equals("[ ]")  ? res : result;
    }
    public String getAccDepositSummary(String clientId) {
        StringBuilder sb = new StringBuilder();
        final String url = "http://localhost:9093/deposit/getDepositAccountsByClientId/"+clientId;
        String result = restTemplate.getForObject(url, String.class);
        String res = g.toJson(statusMsg);
        return result.equals("[ ]") ? res : result;
    }
}
