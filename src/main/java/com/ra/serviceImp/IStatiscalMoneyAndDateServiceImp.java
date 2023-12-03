package com.ra.serviceImp;

import com.ra.model.StatisticalPerformance;
import com.ra.repository.StatisticalMoneyAndDateRepository;
import com.ra.service.IStatiscalMoneyAndDateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class IStatiscalMoneyAndDateServiceImp implements IStatiscalMoneyAndDateService {
    @Autowired
    private StatisticalMoneyAndDateRepository statiscalMoneyAndDateRepository;
    @Override
    public List<StatisticalPerformance> total() {
        return statiscalMoneyAndDateRepository.total();
    }
}
