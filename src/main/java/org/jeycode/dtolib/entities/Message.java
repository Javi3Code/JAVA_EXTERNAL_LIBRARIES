package org.jeycode.dtolib.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public final class Message
{

      private String messageSignature;
      private String messageContent;
}
