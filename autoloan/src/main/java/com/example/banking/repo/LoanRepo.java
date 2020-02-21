package com.example.banking.repo;

import com.example.banking.module.Loan;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LoanRepo extends CrudRepository<Loan, Long> {
    List<Loan> findByClientId(String clientId);
}
