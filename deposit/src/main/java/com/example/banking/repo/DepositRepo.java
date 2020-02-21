package com.example.banking.repo;

import com.example.banking.model.Deposit;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DepositRepo extends CrudRepository<Deposit, Long> {
    List<Deposit> findByClientId(String id);
}
