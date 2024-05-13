package com.javastart.account.controller.dto;

import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AccountRequestDTO {

  private String name;
  private String email;
  private List<Long> bills;
  private String phone;
  private OffsetDateTime creationDate;
}
