package org.jeycode.constants;



import static java.lang.String.format;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;

import org.jeycode.dtolib.dtos.DtoToCreateCustomer;
import org.jeycode.dtolib.entities.Car;
import org.jeycode.dtolib.entities.Customer;
import org.jeycode.dtolib.entities.Message;

import com.github.javafaker.Business;
import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

import lombok.experimental.UtilityClass;

@UtilityClass
public class DataCustomerHelper
{

      private static final Faker faker = Faker.instance(Locale.forLanguageTag("es"));
      private static final RandomService randomService = faker.random();

      public static Customer customer()
      {
            var name = faker.name();
            return Customer.of()
                           .customerId(randomService.nextLong())
                           .name(name.firstName())
                           .surnames(format("%s %s",name.lastName(),name.lastName()))
                           .nif(faker.bothify("#########?",true))
                           .car(car())
                           .units(randomService.nextInt(1,10))
                           .purchaseDate(LocalDate.of(randomService.nextInt(2015,2030),randomService.nextInt(1,12),
                                                      randomService.nextInt(1,28)))
                           .get();
      }

      public static Car car()
      {
            var fakerService = new FakeValuesService(Locale.forLanguageTag("en"),randomService);
            var makesKey = "vehicle.makes";
            var makes = (ArrayList<String>)fakerService.fetchObject(makesKey);
            var make = makes.get(randomService.nextInt(0,makes.size() - 1));
            var modelsByMakeKey = "vehicle.models_by_make";
            var modelsByMake = (ArrayList<String>)fakerService.fetchObject(format("%s.%s",modelsByMakeKey,make));
            var model = modelsByMake.get(randomService.nextInt(0,modelsByMake.size() - 1));
            return Car.of()
                      .carId(randomService.nextLong())
                      .carModel(model)
                      .carBrand(make)
                      .carPrice(randomService.nextInt(50000,500000) / 10f)
                      .carPower(randomService.nextInt(60,250))
                      .get();
      }

      public static Message message()
      {
            Business business = faker.business();
            return new Message(business.creditCardNumber(),business.creditCardType());
      }

      public DtoToCreateCustomer dtoToCreateCustomer()
      {
            var name = faker.name();
            return DtoToCreateCustomer.of()
                                      .name(name.firstName())
                                      .surnames(format("%s %s",name.lastName(),name.lastName()))
                                      .nif(faker.bothify("#########?",true))
                                      .units(randomService.nextInt(1,10))
                                      .purchaseDate(LocalDate.of(randomService.nextInt(2015,2030),randomService.nextInt(1,12),
                                                                 randomService.nextInt(1,28)))
                                      .get();
      }

}
