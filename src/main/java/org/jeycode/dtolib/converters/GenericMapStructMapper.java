package org.jeycode.dtolib.converters;

import org.jeycode.dtolib.dtos.CustomerComplexDto;
import org.jeycode.dtolib.dtos.CustomerSimpleDto;
import org.jeycode.dtolib.dtos.DtoToCreateCustomer;
import org.jeycode.dtolib.dtos.MixDto;
import org.jeycode.dtolib.entities.Customer;
import org.jeycode.dtolib.entities.Message;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface GenericMapStructMapper
{

      CustomerSimpleDto toSimpleDto(Customer customer);

      @Mapping(target = "purchaseDate", ignore = true)
      CustomerSimpleDto toSimpleDtoSkippingDate(Customer customer);

      Customer toCustomer(DtoToCreateCustomer dtoToCreateCustomer);

      @Mapping(source = "car.carPrice", target = "payment")
      CustomerComplexDto toCustomerComplexDto(Customer customer);

      @Mappings({@Mapping(source = "customer.car.carModel", target = "carModel"),
                 @Mapping(source = "customer.car.carBrand", target = "carBrand"),
                 @Mapping(source = "customer.car.carPrice", target = "carPrice"),
                 @Mapping(source = "customer.car.carPower", target = "carPower")})
      MixDto toMixDto(Customer customer,Message message);

}
