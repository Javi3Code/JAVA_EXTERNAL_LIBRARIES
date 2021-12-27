package org.jeycode.dtolib.dtos;

import io.beanmapper.annotations.BeanProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CustomerComplexDto extends CustomerSimpleDto
{

      @BeanProperty("car.carPrice")
      private float payment;

}
