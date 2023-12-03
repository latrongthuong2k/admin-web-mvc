package com.ra.serviceImp;

import com.ra.model.BillDetail;
import com.ra.repository.BillDetailRepository;
import com.ra.service.BillDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillDetailServiceImp implements BillDetailService {
    @Autowired
    private BillDetailRepository billDetailRepository;


    @Override
    public boolean save(BillDetail billDetail) {
        try {
            billDetailRepository.save(billDetail);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;

    }

    @Override
    public boolean update(BillDetail billDetail) {
        return false;
    }

    @Override
    public boolean delete(int billDetailId) {
        return false;
    }

    @Override
    public BillDetail findById(String billId) {
        return billDetailRepository.findAllByBill_BillId(billId);
    }

    @Override
    public List<BillDetail> findDataByBillId(Integer billId) {
        return billDetailRepository.findAllDataByBill_BillId(billId);
    }

    @Override
    public BillDetail findBillDetailById(Integer billDetailId) {
        return billDetailRepository.findByBillId(billDetailId);
    }

    @Override
    public BillDetail findByIdBillDetailId(long billDetailId) {
        return billDetailRepository.findById(billDetailId).get();
    }

}
