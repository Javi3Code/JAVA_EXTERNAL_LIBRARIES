package org.jeycode.dtolib.dtos;

import org.jeycode.dtolib.entities.Message;

import io.beanmapper.annotations.BeanProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class MixDto extends CustomerSimpleDto
{

      private Message message;
      @BeanProperty("car.carModel")
      private String carModel;
      @BeanProperty("car.carBrand")
      private String carBrand;
      @BeanProperty("car.carPrice")
      private float carPrice;
      @BeanProperty("car.carPower")
      private int carPower;
}
