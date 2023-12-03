package com.ra.repository;

import com.ra.model.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account,Integer> {
    @Query("select ac from Account ac where ac.email like %?1%")
    Page<Account> findByEmail(String emailSearch, Pageable pageable);
    int countByEmailContains(String email);

    List<Account>findAllByAccStatusIsTrue();

    @Query("SELECT COUNT(a) FROM Account a WHERE a.accStatus = true")
    int statisticalAccountActive();


    @Query("SELECT COUNT(a) FROM Account a WHERE a.accStatus = false ")
    int statisticalAccountInActive();
}
