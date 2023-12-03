package com.ra.serviceImp;

import com.ra.model.Bill;
import com.ra.repository.BillRepository;
import com.ra.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class BillServiceImp implements BillService {
    @Autowired
    private BillRepository billRepository;
    @Override
    public Page<Bill> displayData(String billIdSearch, int page, int size, String direction, String sortBy) {
        //Khởi tạo đối tượng Pageable
        Pageable pageable = PageRequest.of(page, size,
                direction.equals("ASC") ? Sort.Direction.ASC : Sort.Direction.DESC, sortBy);
        return billRepository.searchByBillIdAdEmail(billIdSearch,pageable);
    }

    @Override
    public int getListPage(String billId) {
        return billRepository.countByBillIdContains(billId);
    }

    @Override
    public Bill findById(Integer billId) {
        return billRepository.findById(billId).orElse(null);
    }


    @Override
    public boolean saveOrUpdate(Bill bill) {
        try {
            billRepository.save(bill);
            return true;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(String billId) {
        return false;
    }

    @Override
    public boolean isCheckBillStatus(Integer billId) {
        try {
            boolean isCheck = billRepository.isCheckBillStatus(billId);
            if (isCheck) {
                return true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }


    @Override
    public int statisticalPending() {
        return billRepository.pendingBills();
    }

    @Override
    public int statisticalApproved() {
        return billRepository.approveBills();
    }

    @Override
    public int statisticalDelivering() {
        return billRepository.deliveringBills();
    }

    @Override
    public int statisticalReceived() {
        return billRepository.receivedBills();
    }

    @Override
    public int statisticalCanceled() {
        return billRepository.canceledBills();
    }
}
