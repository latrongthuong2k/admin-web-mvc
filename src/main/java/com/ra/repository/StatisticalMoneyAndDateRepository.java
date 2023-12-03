package com.ra.repository;

import com.ra.model.StatisticalPerformance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatisticalMoneyAndDateRepository extends JpaRepository<StatisticalPerformance, Integer> {

    @Query("SELECT NEW com.ra.model.StatisticalPerformance(SUM(bd.total), bi.created) " +
            "FROM BillDetail bd " +
            "JOIN bd.bill bi " +
            "WHERE bi.billStatus = 2 AND DATE(bi.created) = CURRENT_DATE " +
            "GROUP BY bi.created")
    List<StatisticalPerformance> total();




}
