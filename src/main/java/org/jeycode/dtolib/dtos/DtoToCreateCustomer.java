package org.jeycode.dtolib.dtos;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(builderMethodName = "of", buildMethodName = "get")
public class DtoToCreateCustomer
{

      private String name,surnames,nif;
      private LocalDate purchaseDate;
      private int units;
}
