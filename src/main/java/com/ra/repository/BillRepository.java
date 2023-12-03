package com.ra.repository;

import com.ra.model.Bill;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepository extends JpaRepository<Bill, Integer> {
    @Query("select bi from Bill bi where cast(bi.billId as string )  like %?1% or bi.account.email like %?1% ")
    Page<Bill> searchByBillIdAdEmail(String billIdSearch, Pageable pageable);

    int countByBillIdContains(String billId);

    @Query("select COUNT(bi.billId)>=1 from Bill bi where bi.billId=:billId and bi.billStatus=1")
    boolean isCheckBillStatus(@Param("billId") Integer billId);

    @Query("SELECT COUNT(bi) FROM Bill bi WHERE bi.billStatus = 1")
    int pendingBills();

    @Query("SELECT COUNT(bi) FROM Bill bi WHERE bi.billStatus = 2")
    int approveBills();

    @Query("SELECT COUNT(bi) FROM Bill bi WHERE bi.billStatus = 3")
    int deliveringBills();

    @Query("SELECT COUNT(bi) FROM Bill bi WHERE bi.billStatus = 4")
    int receivedBills();

    @Query("SELECT COUNT(bi) FROM Bill bi WHERE bi.billStatus = 5")
    int canceledBills();


}
