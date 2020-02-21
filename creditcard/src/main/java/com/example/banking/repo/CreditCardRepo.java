package com.example.banking.repo;

import com.example.banking.model.CreditCard;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CreditCardRepo extends CrudRepository<CreditCard, Long> {
    List<CreditCard> findByClientId(String id);
}
