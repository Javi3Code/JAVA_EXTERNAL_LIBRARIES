package org.jeycode.datagenerator.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder(builderMethodName = "of", toBuilder = true, buildMethodName = "construct")
@Data
public class Employee
{

      private String name,surnames,category,NIF;
      private int age,employeeNumber;
      private LocalDate birthdate;
      private float salary,IRPF;
}
