package com.ra.service;

import com.ra.model.Bill;
import org.springframework.data.domain.Page;

public interface BillService {
    Page<Bill> displayData(String billIdSearch, int page, int size, String direction, String sortBy);
    int getListPage(String billId);
    Bill findById(Integer billId);
    boolean saveOrUpdate(Bill bill);

    boolean delete(String billId);
    boolean isCheckBillStatus(Integer billId);
    int statisticalPending();
    int statisticalApproved();
    int statisticalDelivering();
    int statisticalReceived();
    int statisticalCanceled();


}
