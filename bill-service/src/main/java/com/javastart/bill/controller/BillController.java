package com.javastart.bill.controller;

import com.javastart.bill.dto.BillRequestDTO;
import com.javastart.bill.dto.BillResponseDTO;
import com.javastart.bill.service.BillService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BillController {

  private final BillService billService;

  public BillController(BillService billService) {
    this.billService = billService;
  }

  @GetMapping("/{billId}")
  public BillResponseDTO getBill(@PathVariable Long billId) {
    return new BillResponseDTO(billService.getBillById(billId));
  }

  @PostMapping("/")
  public Long createBill(@RequestBody BillRequestDTO billRequestDto) {
    return billService.createBill(billRequestDto.getAccountId(), billRequestDto.getAmount(), billRequestDto.getIsDefault(),
        billRequestDto.getOverdraftEnabled());
  }

  @PutMapping("/{billId}")
  public BillResponseDTO updateBill(@PathVariable Long billId, @RequestBody BillRequestDTO billRequestDto) {
    return new BillResponseDTO(billService.updateBill(billId, billRequestDto.getAccountId(), billRequestDto.getAmount(),
        billRequestDto.getIsDefault(), billRequestDto.getOverdraftEnabled()));
  }

  @DeleteMapping("/{billId}")
  public BillResponseDTO deleteBill(@PathVariable Long billId) {
    return new BillResponseDTO(billService.deleteBill(billId));
  }
}
