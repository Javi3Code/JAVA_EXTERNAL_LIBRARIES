package org.jeycode.dtolib.converters.impl;

import org.jeycode.dtolib.dtos.MixDto;
import org.jeycode.dtolib.entities.Message;

public class GenericSelmaMapperInterceptor
{

      public MixDto interceptAndSetMessage(Message message,MixDto mixDto)
      {
            mixDto.setMessage(message);
            return mixDto;
      }

}
