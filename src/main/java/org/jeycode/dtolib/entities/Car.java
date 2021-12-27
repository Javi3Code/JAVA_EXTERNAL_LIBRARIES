package org.jeycode.dtolib.entities;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder(builderClassName = "CarBuilder", builderMethodName = "of", buildMethodName = "get")
public class Car
{

      private long carId;
      @NonNull
      private String carModel,carBrand;
      private float carPrice;
      private int carPower;
}
