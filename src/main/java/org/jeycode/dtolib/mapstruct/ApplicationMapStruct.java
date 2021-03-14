package org.jeycode.dtolib.mapstruct;

import java.time.LocalDate;

import org.jeycode.dtolib.converters.GenericMapStructMapper;
import org.jeycode.dtolib.dtos.DtoToCreateCustomer;
import org.jeycode.dtolib.entities.Car;
import org.jeycode.dtolib.entities.Customer;
import org.jeycode.dtolib.entities.Message;
import org.mapstruct.factory.Mappers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public final class ApplicationMapStruct
{

      static Gson gsonConverter = new GsonBuilder().setPrettyPrinting()
                                                   .create();

      static GenericMapStructMapper genericMapper = Mappers.getMapper(GenericMapStructMapper.class);

      public static void main(String[] args)
      {

            var car = Car.of()
                         .carId(1)
                         .carBrand("MariCarmen")
                         .carModel("V8-Z")
                         .carPrice(23445.04f)
                         .carPower(120)
                         .get();

            var customer = Customer.of()
                                   .customerId(1)
                                   .name("Pedro")
                                   .surnames("Gallo Martín")
                                   .nif("3242424V")
                                   .units(3)
                                   .car(car)
                                   .purchaseDate(LocalDate.of(2021,03,23))
                                   .get();

            var message = new Message();
            message.setMessageSignature("Javier::Venta::" + LocalDate.now()
                                                                     .toString());
            message.setMessageContent("Aquí tienes los datos que pedías....");

            var customerDto = DtoToCreateCustomer.of()
                                                 .name("Rodrigo")
                                                 .surnames("Díaz de Vivar")
                                                 .nif("234234P")
                                                 .units(3)
                                                 .purchaseDate(LocalDate.of(2021,05,22))
                                                 .get();

            var mapSimple = genericMapper.toSimpleDto(customer);
            System.out.println("Mapeado Simple:\n" + gsonConverter.toJson(mapSimple));

            var mapSimpleSkip = genericMapper.toSimpleDtoSkippingDate(customer);
            System.out.println("Mapeado Simple skipeando:\n" + gsonConverter.toJson(mapSimpleSkip));

            var mapReverse = genericMapper.toCustomer(customerDto);
            System.out.println("Mapeado Reverse:\n" + gsonConverter.toJson(mapReverse));

            var mapComplex = genericMapper.toCustomerComplexDto(customer);
            System.out.println("Mapeado Complex:\n" + gsonConverter.toJson(mapComplex));

            var mapMix = genericMapper.toMixDto(customer,message);
            System.out.println("Mapeado Mix:\n" + gsonConverter.toJson(mapMix));

      }

}
