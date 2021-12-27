package org.jeycode.dtolib.converters.impl;

import org.jeycode.dtolib.converters.GenericMapper;
import org.jeycode.dtolib.dtos.CustomerComplexDto;
import org.jeycode.dtolib.dtos.CustomerSimpleDto;
import org.jeycode.dtolib.dtos.MixDto;
import org.jeycode.dtolib.entities.Customer;
import org.jeycode.dtolib.entities.Message;

import fr.xebia.extras.selma.Field;
import fr.xebia.extras.selma.IgnoreMissing;
import fr.xebia.extras.selma.Mapper;
import fr.xebia.extras.selma.Maps;

@Mapper(withIgnoreMissing = IgnoreMissing.ALL)
public interface GenericSelmaMapper  extends GenericMapper
{


      @Override
      @Maps(withIgnoreFields = "purchaseDate")
      CustomerSimpleDto toSimpleDtoSkippingDate(Customer customer);

      @Override
      @Maps(withCustomFields = @Field({"car.carPrice","payment"}))
      CustomerComplexDto toCustomerComplexDto(Customer customer);

      @Override
      @Maps(withCustomFields = {@Field({"car.carModel","carModel"}),@Field({"car.carBrand","carBrand"}),@Field({"car.carPrice","carPrice"}),
                                @Field({"car.carPower","carPower"})},
            withCustom = GenericSelmaMapperInterceptor.class)
      MixDto toMixDto(Customer customer,Message message);

}
