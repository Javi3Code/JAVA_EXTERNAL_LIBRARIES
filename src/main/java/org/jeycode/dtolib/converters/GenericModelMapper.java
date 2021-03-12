package org.jeycode.dtolib.converters;

import org.jeycode.dtolib.dtos.CustomerComplexDto;
import org.jeycode.dtolib.dtos.CustomerSimpleDto;
import org.jeycode.dtolib.dtos.DtoToCreateCustomer;
import org.jeycode.dtolib.dtos.MixDto;
import org.jeycode.dtolib.entities.Customer;
import org.jeycode.dtolib.entities.Message;
import org.modelmapper.ModelMapper;

public class GenericModelMapper
{

      private final ModelMapper mapper = new ModelMapper();

      private static GenericModelMapper instance;

      private GenericModelMapper()
      {}

      public static GenericModelMapper singleInstance()
      {
            if (instance == null)
            {
                  instance = new GenericModelMapper();
            }
            return instance;
      }

      public CustomerSimpleDto mapToCustomerSimpleDto(Customer customer)
      {
            return mapper.map(customer,CustomerSimpleDto.class);
      }

      public CustomerSimpleDto mapToCustomerSimpleDtoSkippingDate(Customer customer)
      {
            return mapper.typeMap(Customer.class,CustomerSimpleDto.class)
                         .addMappings(mappr-> mappr.skip(CustomerSimpleDto::setPurchaseDate))
                         .map(customer);
      }

      public Customer reverseMap(DtoToCreateCustomer customerDto)
      {
            return mapper.map(customerDto,Customer.class);
      }

      public CustomerComplexDto mapToCustomerComplexDto(Customer customer)
      {
            return mapper.typeMap(Customer.class,CustomerComplexDto.class)
                         .addMapping(cust-> cust.getCar()
                                                .getCarPrice(),
                                     CustomerComplexDto::setPayment)
                         .map(customer);
      }

      public MixDto mapToMixDto(Customer customer,Message message)
      {
            var mixDto = new MixDto();
            mapper.map(customer,mixDto);
            mapper.map(message,mixDto);
            return mixDto;
      }

}
