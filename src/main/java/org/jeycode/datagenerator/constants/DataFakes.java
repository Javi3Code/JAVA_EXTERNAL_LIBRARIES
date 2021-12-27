package org.jeycode.datagenerator.constants;

import static java.lang.String.format;
import static java.time.LocalDate.now;
import static java.time.LocalDate.ofInstant;
import static java.time.Period.between;
import static java.time.ZoneId.systemDefault;
import static java.util.Locale.forLanguageTag;
import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.IntStream;

import org.jeycode.datagenerator.model.Employee;

import com.github.javafaker.Faker;
import com.github.javafaker.service.RandomService;

import lombok.experimental.UtilityClass;

@UtilityClass
public class DataFakes
{

      public static List<Employee> getSetOfFakeDataoOf(int size)
      {
            var faker= Faker.instance(forLanguageTag("es"));
            var random= faker.random();
            return IntStream.range(0,size)
                        .mapToObj(num->getFakeEmployee(faker,random))
                        .collect(toList());
      }
      
     //@formatter:off
      private static Employee getFakeEmployee(Faker faker,RandomService randomService)
      {
            var nameComplete= faker.name();
            var zone=systemDefault();
            var randomDate= ofInstant(faker.date().birthday().toInstant(),zone);
            
            return Employee.of()
                        .name(nameComplete.firstName())
                        .surnames(format("%s %s",nameComplete.lastName(),nameComplete.lastName()))
                        .birthdate(randomDate)
                        .age(between(randomDate,now()).getYears())
                        .category(faker.job().position())
                        .employeeNumber(randomService.nextInt(100,10000))
                        .NIF(faker.bothify("########?",true))
                        .IRPF(randomService.nextInt(20,400)/10f)
                        .salary(randomService.nextInt(1000,5000))
                     .construct();
      }
      
      public static Map<Integer,Function<Employee,?>> getters =
                              Map.of(
                                     0, Employee::getName,
                                     1, Employee::getSurnames,
                                     2, Employee::getAge,
                                     3, Employee::getCategory,
                                     4, Employee::getBirthdate,
                                     5, Employee::getEmployeeNumber,
                                     6, Employee::getIRPF,
                                     7, Employee::getSalary,
                                     8, Employee::getNIF
                                     );
                 //@formatter:on             
      
      
      
      
      
      
      
      
      
      
}