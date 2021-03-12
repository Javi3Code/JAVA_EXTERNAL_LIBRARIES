package org.jeycode.lombok;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class User
{

      @NonNull
      private final String nick,mail,pass;
      private String name;
}
