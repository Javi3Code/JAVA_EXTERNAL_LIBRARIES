package org.jeycode.dtolib.dtos;

import org.jeycode.dtolib.entities.Message;

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
      private String carModel,carBrand;
      private float carPrice;
      private int carPower;
}
