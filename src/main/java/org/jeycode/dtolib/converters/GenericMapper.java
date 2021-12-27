package org.jeycode.dtolib.converters;

import org.jeycode.dtolib.dtos.CustomerComplexDto;
import org.jeycode.dtolib.dtos.CustomerSimpleDto;
import org.jeycode.dtolib.dtos.DtoToCreateCustomer;
import org.jeycode.dtolib.dtos.MixDto;
import org.jeycode.dtolib.entities.Customer;
import org.jeycode.dtolib.entities.Message;

public interface GenericMapper
{

      CustomerSimpleDto toSimpleDto(Customer customer);

      CustomerSimpleDto toSimpleDtoSkippingDate(Customer customer);

      Customer toCustomer(DtoToCreateCustomer dtoToCreateCustomer);

      CustomerComplexDto toCustomerComplexDto(Customer customer);

      MixDto toMixDto(Customer customer,Message message);
}
