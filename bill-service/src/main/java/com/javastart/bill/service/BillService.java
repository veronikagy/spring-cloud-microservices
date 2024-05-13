package com.javastart.bill.service;

import com.javastart.bill.entity.Bill;
import com.javastart.bill.exception.BillNotFoundException;
import com.javastart.bill.repository.BillRepository;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import org.springframework.stereotype.Service;

@Service
public class BillService {

  private final BillRepository billRepository;

  public BillService(BillRepository billRepository) {
    this.billRepository = billRepository;
  }

  public Bill getBillById(Long billId) {
    return billRepository.findById(billId)
        .orElseThrow(() -> new BillNotFoundException("Unabled to find bill with id:" + billId));
  }

  public Long createBill(Long accountId, BigDecimal amount, Boolean isDefault, Boolean overdraftEnabled) {
    Bill bill = new Bill(accountId, amount, isDefault, OffsetDateTime.now(), overdraftEnabled);
    return billRepository.save(bill).getBillId();
  }

  public Bill updateBill(Long billId, Long accountId, BigDecimal amount, Boolean isDefault, Boolean overdraftEnabled) {
    Bill bill = new Bill(accountId, amount, isDefault, overdraftEnabled);
    bill.setBillId(billId);
    return billRepository.save(bill);
  }

  public Bill deleteBill(Long billId) {
    Bill bill = getBillById(billId);
    billRepository.deleteById(billId);
    return bill;
  }
}
