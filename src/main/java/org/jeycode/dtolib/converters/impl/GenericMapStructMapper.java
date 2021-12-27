package org.jeycode.dtolib.converters.impl;

import org.jeycode.dtolib.converters.GenericMapper;
import org.jeycode.dtolib.dtos.CustomerComplexDto;
import org.jeycode.dtolib.dtos.CustomerSimpleDto;
import org.jeycode.dtolib.dtos.MixDto;
import org.jeycode.dtolib.entities.Customer;
import org.jeycode.dtolib.entities.Message;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface GenericMapStructMapper extends GenericMapper
{


      @Override
      @Mapping(target = "purchaseDate", ignore = true)
      CustomerSimpleDto toSimpleDtoSkippingDate(Customer customer);


      @Override
      @Mapping(source = "car.carPrice", target = "payment")
      CustomerComplexDto toCustomerComplexDto(Customer customer);

      @Override
      @Mappings({@Mapping(source = "customer.car.carModel", target = "carModel"),
                 @Mapping(source = "customer.car.carBrand", target = "carBrand"),
                 @Mapping(source = "customer.car.carPrice", target = "carPrice"),
                 @Mapping(source = "customer.car.carPower", target = "carPower")})
      MixDto toMixDto(Customer customer,Message message);

}
