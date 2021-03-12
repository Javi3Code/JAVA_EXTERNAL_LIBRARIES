package org.jeycode.dtolib.modelmapper;

import java.time.LocalDate;

import org.jeycode.dtolib.converters.GenericModelMapper;
import org.jeycode.dtolib.dtos.DtoToCreateCustomer;
import org.jeycode.dtolib.entities.Car;
import org.jeycode.dtolib.entities.Customer;
import org.jeycode.dtolib.entities.Message;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public final class ApplicationModelMapper
{

      static Gson gsonConverter = new GsonBuilder().setPrettyPrinting()
                                                   .create();

      static GenericModelMapper modelMapper = GenericModelMapper.singleInstance();

      public static void main(String[] args)
      {

            var car = Car.of()
                         .carId(1)
                         .carBrand("MariCarmen")
                         .carModel("V8-G")
                         .carPrice(20000.02f)
                         .carPower(200)
                         .get();

            var customer = Customer.of()
                                   .customerId(1)
                                   .name("Pedro")
                                   .surnames("de la Torre")
                                   .nif("23423423F")
                                   .units(3)
                                   .car(car)
                                   .purchaseDate(LocalDate.of(2020,12,12))
                                   .get();

            var message = new Message();
            message.setMessageSignature("Javier::Venta::" + LocalDate.now());
            message.setMessageContent("Aquí tienes los datos que pedías....");

            var customerSimpleDto = modelMapper.mapToCustomerSimpleDto(customer);
            System.out.println("CustomerSimpleDto:\n" + gsonConverter.toJson(customerSimpleDto));

            var customerSimpleDtoS = modelMapper.mapToCustomerSimpleDtoSkippingDate(customer);
            System.out.println("CustomerSimpleDtoSkip:\n" + gsonConverter.toJson(customerSimpleDtoS));

            DtoToCreateCustomer customerDto = DtoToCreateCustomer.of()
                                                                 .name("Pedro")
                                                                 .surnames("de la Torre")
                                                                 .nif("23423423F")
                                                                 .units(3)
                                                                 .purchaseDate(LocalDate.of(2020,12,12))
                                                                 .get();
            var customerC = modelMapper.reverseMap(customerDto);
            System.out.println("customerC:\n" + gsonConverter.toJson(customerC));

            var customerComplexDto = modelMapper.mapToCustomerComplexDto(customer);
            System.out.println("customerComplexDto:\n" + gsonConverter.toJson(customerComplexDto));

            var customerMixDto = modelMapper.mapToMixDto(customer,message);
            System.out.println("customerMixDto:\n" + gsonConverter.toJson(customerMixDto));

      }
}
