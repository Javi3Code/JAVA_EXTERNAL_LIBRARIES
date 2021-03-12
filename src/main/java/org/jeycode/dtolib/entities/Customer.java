package org.jeycode.dtolib.entities;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@Builder(builderClassName = "CustomerBuilder", builderMethodName = "of", buildMethodName = "get")
@NoArgsConstructor
@AllArgsConstructor
public class Customer
{

      private long customerId;
      @NonNull
      private String name,surnames,nif;
      private Car car;
      private int units;
      @NonNull
      private LocalDate purchaseDate;

}
