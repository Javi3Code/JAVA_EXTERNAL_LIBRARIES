package org.jeycode.dtolib.converters.impl;

import java.util.List;

import org.jeycode.dtolib.converters.GenericMapper;
import org.jeycode.dtolib.dtos.CustomerComplexDto;
import org.jeycode.dtolib.dtos.CustomerSimpleDto;
import org.jeycode.dtolib.dtos.DtoToCreateCustomer;
import org.jeycode.dtolib.dtos.MixDto;
import org.jeycode.dtolib.entities.Customer;
import org.jeycode.dtolib.entities.Message;

import io.beanmapper.BeanMapper;
import io.beanmapper.config.BeanMapperBuilder;

public final class GenericBeanmapperMapper implements GenericMapper
{

      private static GenericBeanmapperMapper instance;
      private final BeanMapper mapper = new BeanMapperBuilder().build();

      private GenericBeanmapperMapper()
      {}

      public static GenericBeanmapperMapper singleInstance()
      {
            return instance == null ? new GenericBeanmapperMapper() : instance;
      }

      @Override
      public CustomerSimpleDto toSimpleDto(Customer customer)
      {
            return mapper.map(customer,CustomerSimpleDto.class);
      }

      @Override
      public CustomerSimpleDto toSimpleDtoSkippingDate(Customer customer)
      {
            return mapper.wrap()
                         .downsizeSource(List.of("customerId","name","surnames","nif"))
                         .build()
                         .map(customer,CustomerSimpleDto.class);
      }

      @Override
      public Customer toCustomer(DtoToCreateCustomer dtoToCreateCustomer)
      {
            return mapper.map(dtoToCreateCustomer,Customer.class);
      }

      @Override
      public CustomerComplexDto toCustomerComplexDto(Customer customer)
      {
            return mapper.map(customer,CustomerComplexDto.class);
      }

      @Override
      public MixDto toMixDto(Customer customer,Message message)
      {
            var mixDto = mapper.map(customer,MixDto.class);
            mixDto.setMessage(message);
            return mixDto;
      }
}
