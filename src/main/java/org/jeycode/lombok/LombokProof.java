package org.jeycode.lombok;

public class LombokProof
{

      public static void main(String[] args)
      {
            User user = new User(null,null,null);
            print(user);
            
      }
      
      private static void print( User user)
      {
            
            System.out.println( user);
      }
}
