package com.ra.service;

import com.ra.model.BillDetail;

import java.util.List;

public interface BillDetailService {
    boolean save(BillDetail billDetail);
    boolean update(BillDetail billDetail);
    boolean delete(int billDetailId);
    BillDetail findById(String billId);
    BillDetail findByIdBillDetailId(long billDetailId);

    List<BillDetail> findDataByBillId(Integer billId);
    BillDetail findBillDetailById(Integer billId);


}
