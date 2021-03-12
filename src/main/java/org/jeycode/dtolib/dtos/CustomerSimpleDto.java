package org.jeycode.dtolib.dtos;

import java.time.LocalDate;

import lombok.Data;

@Data
public class CustomerSimpleDto
{
      private long customerId;
      private String name,surnames,nif;
      private LocalDate purchaseDate;
}
