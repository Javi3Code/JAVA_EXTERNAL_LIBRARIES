package org.jeycode.dtolib.dtos;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CustomerComplexDto extends CustomerSimpleDto
{

      private float payment;
      
}
