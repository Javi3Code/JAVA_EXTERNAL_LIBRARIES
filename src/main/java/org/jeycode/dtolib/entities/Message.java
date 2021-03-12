package org.jeycode.dtolib.entities;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public final class Message
{

      private String messageSignature;
      private String messageContent;
}
